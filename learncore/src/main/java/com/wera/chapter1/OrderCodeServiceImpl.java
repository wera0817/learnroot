package com.wera.chapter1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

/**
 * 业务实现层
 * Created by Dell on 2018/5/15.
 */
public class OrderCodeServiceImpl {
    final static OrderCodeGenerator ocg = new OrderCodeGenerator();
    private CountDownLatch cdl;

    public OrderCodeServiceImpl(int size) {
        cdl = new CountDownLatch(size);
    }
    //自定义锁的实现
    Lock lock = new DistributedLock("/test");

    public void createOrder() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    lock.lock();
                    cdl.await();//阻塞等待，所有线程创建完毕。模拟并发情况
                    ocg.getOrderCode();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }

    /**
     * 计数递减的方法
     */
    public void countDown() {
        this.cdl.countDown();
    }
}

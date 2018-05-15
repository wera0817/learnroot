package com.wera.chapter1;


/**
 * Created by Dell on 2018/5/15.
 */
public class OrderCodeTest {

    public static void main(String[] args) throws InterruptedException {
        int size = 20;
        OrderCodeServiceImpl orderCodeService = new OrderCodeServiceImpl(size);
        for (int i = 0; i < size; i++) {
            orderCodeService.createOrder();//调用业务层的逻辑
            orderCodeService.countDown();//调用一次计数减一次
        }

    }
}

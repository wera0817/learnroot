package com.wera.chapter1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * orderCode 生成类 这个是我们要操作的目标对象
 * Created by Dell on 2018/5/15.
 */
public class OrderCodeGenerator {
    private int i = 1;

    public String getOrderCode() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss " + (i++));
        String s = simpleDateFormat.format(new Date());
        System.out.println(s);
        return s;
    }
}

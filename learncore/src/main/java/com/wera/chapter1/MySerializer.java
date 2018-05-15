package com.wera.chapter1;

import org.I0Itec.zkclient.exception.ZkMarshallingError;
import org.I0Itec.zkclient.serialize.ZkSerializer;

import java.io.UnsupportedEncodingException;

/**
 * 序列话接口实现类
 * Created by Dell on 2018/5/15.
 */
public class MySerializer implements ZkSerializer {
    public byte[] serialize(Object data) throws ZkMarshallingError {
        try {
            return ((String)data).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    public Object deserialize(byte[] bytes) throws ZkMarshallingError {
        try {
            return new String(bytes,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new String();
    }
}

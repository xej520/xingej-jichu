package com.xingej.proxy;

public class ZhangSan implements Person{

    @Override
    public void eat() throws Exception {
        System.out.println("----张三吃饭的时候---喜欢看<<青云志>>-----");
    }

    @Override
    public void sleep() throws Exception {
        System.out.println("----张三睡觉的时候---喜欢磨牙------");
    }

    @Override
    public void hit() throws Exception {
        System.out.println("-----喜欢喝美女一起打豆豆------");
    }

}

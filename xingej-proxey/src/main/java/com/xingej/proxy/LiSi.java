package com.xingej.proxy;

public class LiSi implements Person{

    @Override
    public void eat() throws Exception {
        System.out.println("----李四---吃饭的时候---喜欢看<<聊斋>>-----");
    }

    @Override
    public void sleep() throws Exception {
        System.out.println("----李四---睡觉的时候---喜欢磨牙------");
    }

    @Override
    public void hit() throws Exception {
        System.out.println("----李四---喜欢喝美女---一起打豆豆------");
    }

}

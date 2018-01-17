package com.xingej.thread.multiProducerConsumer;

import static org.junit.Assert.*;


public class ResourceTest {

    public static void main(String[] args) {
        Resource appleX = new Resource();
        
        //启动生产线程来生产
        new Thread(new Producer(appleX)).start();
        new Thread(new Producer(appleX)).start();
        
        //启动消费线程来消费
        new Thread(new Consumer(appleX)).start();
        new Thread(new Consumer(appleX)).start();
    }

}

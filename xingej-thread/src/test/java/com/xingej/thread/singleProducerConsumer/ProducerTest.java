package com.xingej.thread.singleProducerConsumer;


import junit.framework.TestCase;

public class ProducerTest extends TestCase {
   
    public static void main(String[] args) {
        Resource appleX = new Resource();
        
        //启动生产线程来生产
        new Thread(new Producer(appleX)).start();
        
        //启动消费线程来消费
        new Thread(new Consumer(appleX)).start();
    }
    
}

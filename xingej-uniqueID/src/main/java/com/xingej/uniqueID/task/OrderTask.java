package com.xingej.uniqueID.task;

import java.util.concurrent.CountDownLatch;

import com.xingej.uniqueID.util.OrderServer;

public class OrderTask implements Runnable{
    
    CountDownLatch latch ;
    
    OrderServer orderServer;
    
    public OrderTask(CountDownLatch latch, OrderServer orderServer) {
        this.latch = latch;
        this.orderServer = orderServer;
    }
    
    public void run() {
        System.out.println(Thread.currentThread().getName() + "  订单号:\t" + orderServer.getOrderNo());
        
        latch.countDown(); 
    }
}

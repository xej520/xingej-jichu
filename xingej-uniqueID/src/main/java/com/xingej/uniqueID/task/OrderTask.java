package com.xingej.uniqueID.task;

import java.util.concurrent.CountDownLatch;

import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import com.xingej.uniqueID.util.OrderServer;

public class OrderTask implements Runnable{
    
    CountDownLatch latch ;
    
    OrderServer orderServer;
    
    InterProcessMutex interProcessMutex;
    
    public OrderTask(CountDownLatch latch, OrderServer orderServer) {
        this.latch = latch;
        this.orderServer = orderServer;
    }
    
    public OrderTask(CountDownLatch latch, OrderServer orderServer, InterProcessMutex interProcessMutex) {
        this.latch = latch;
        this.orderServer = orderServer;
        this.interProcessMutex = interProcessMutex;
    }
    
    public void run() {

        try {
            //来获取锁的
            interProcessMutex.acquire();
            
            System.out.println(Thread.currentThread().getName() + "  订单号:\t" + orderServer.getOrderNo());
            
            latch.countDown(); 
            
            //释放锁资源
            interProcessMutex.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.xingej.uniqueID.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.xingej.uniqueID.task.OrderTask;
import com.xingej.uniqueID.util.OrderAtomicServiceImpl;
import com.xingej.uniqueID.util.OrderRedisServiceImpl;
import com.xingej.uniqueID.util.OrderServer;

public class RedisAtomicOrder {
   public static void main(String[] args) {
        
        ExecutorService executorService = Executors.newCachedThreadPool();
        
        final CountDownLatch latch = new CountDownLatch(10);
        
        OrderServer orderServer = new OrderRedisServiceImpl();
        
        for(int i = 0; i < 7; i++){
            executorService.submit(new OrderTask(latch, orderServer));
        }
        
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------");
        executorService.shutdown();
        
        
    }
}

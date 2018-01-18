package com.xingej.uniqueID.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.xingej.uniqueID.task.OrderTask;
import com.xingej.uniqueID.util.OrderAtomicServiceImpl;
import com.xingej.uniqueID.util.OrderLockServiceImpl;
import com.xingej.uniqueID.util.OrderServer;

public class JvmLockOrder {
    
  public static void main(String[] args) {
        
        ExecutorService executorService = Executors.newCachedThreadPool();
        
        final CountDownLatch latch = new CountDownLatch(10);
        
        OrderServer orderServer = new OrderLockServiceImpl();
        
        for(int i = 0; i < 10; i++){
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

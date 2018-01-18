package com.xingej.uniqueID.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.xingej.uniqueID.task.OrderTask;
import com.xingej.uniqueID.util.OrderAtomicServerImpl;
import com.xingej.uniqueID.util.OrderServer;
//JVM单进程内，形成的唯一号

//非分布式方式
public class JvmAtomicOrder {
    public static void main(String[] args) {
        
        ExecutorService executorService = Executors.newCachedThreadPool();
        
        final CountDownLatch latch = new CountDownLatch(10);
        
        OrderServer orderServer = new OrderAtomicServerImpl();
        
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

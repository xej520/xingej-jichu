package com.xingej.uniqueID.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import com.xingej.uniqueID.task.OrderTask;
import com.xingej.uniqueID.util.OrderNoLockServiceImpl;
import com.xingej.uniqueID.util.OrderServer;

public class CuratorLockOrder {
    
    private static final CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("192.168.1.110:2181").retryPolicy(new ExponentialBackoffRetry(100, 3)).build();

    public static void main(String[] args) {

        client.start();
        
        ExecutorService executorService = Executors.newCachedThreadPool();

        final CountDownLatch latch = new CountDownLatch(10);
        
        final InterProcessMutex lock = new InterProcessMutex(client, "/t1");

        //使用无锁方式
        OrderServer orderServer = new OrderNoLockServiceImpl();

        for (int i = 0; i < 10; i++) {
            executorService.submit(new OrderTask(latch, orderServer, lock));
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

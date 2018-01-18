package com.xingej.uniqueID;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OrderNoLock {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
    
        final CountDownLatch latch = new CountDownLatch(10);
        
        for(int i = 0; i < 10; i++){
            executorService.submit(new Runnable() {
                
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "  订单号:\t"+getOrderNo());
                    
                    latch.countDown();
                }
            });
        }
        
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------");
        executorService.shutdown();
    }

    //以时间戳生成ID号
    public static String getOrderNo() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYmmDDHHMMSS");
        return simpleDateFormat.format(new Date());
    }

}


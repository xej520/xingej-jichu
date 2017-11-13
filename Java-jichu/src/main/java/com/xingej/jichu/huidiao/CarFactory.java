package com.xingej.jichu.huidiao;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;

public class CarFactory {

    //
    public void buildCar(NotifyConsumer callback, String msg) {
        System.out.println("----稍等，我开始准备执行------");

        if (msg.startsWith("H")) {
            msg = msg.toLowerCase();
        } else {
            msg = msg.toUpperCase();
        }

        // 休息5秒钟
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        callback.tell(msg);

        System.out.println("-----执行完成了------");
    }

    @Test
    public void testMulThread() {
        System.out.println("-----------");

        CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(10 * 1000);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("-----2------");
    }
}

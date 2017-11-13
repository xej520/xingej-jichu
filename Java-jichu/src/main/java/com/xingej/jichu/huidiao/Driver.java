package com.xingej.jichu.huidiao;

import java.util.concurrent.CountDownLatch;

public class Driver implements NotifyConsumer {

    private CarFactory carFactory;

    public Driver(CarFactory carFactory) {
        this.carFactory = carFactory;
    }

    // 同步调用
    public void buyCar() {
        String msg = "Hi, 我要买车！";

        carFactory.buildCar(this, msg);
    }

    // 异步调用
    public void buyCarAsync() {
        final String msg = "Hi, 我要买车！";

        CountDownLatch count = new CountDownLatch(1);

        new Thread(new Runnable() {

            @Override
            public void run() {
                carFactory.buildCar(Driver.this, msg);
                count.countDown();
            }
        }).start();

        try {
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void tell(String type) {
        System.out.println("----大王，车准备好了!----");
    }

}

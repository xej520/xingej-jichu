package com.xingej.jichu.huidiao;

import org.junit.Test;

public class HuiDiaoTest {

    // 回调测试, 同步方式
    @Test
    public void testHuiDiao() {
        CarFactory carFactory = new CarFactory();

        Driver driver = new Driver(carFactory);

        // 同步方式，
        driver.buyCar();

    }

    // 回调测试, 异步方式
    @Test
    public void testHuiDiaoByAsync() {
        CarFactory carFactory = new CarFactory();

        Driver driver = new Driver(carFactory);

        // 同步方式，
        driver.buyCarAsync();

    }

}

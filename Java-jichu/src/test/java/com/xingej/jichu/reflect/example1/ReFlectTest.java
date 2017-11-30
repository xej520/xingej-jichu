package com.xingej.jichu.reflect.example1;

import org.junit.Test;

public class ReFlectTest {

    @Test
    public void test() throws Exception {

        // 获取类型
        // -------当这里的参数动态变化时，----某些情况下，就可以替代----switch语句了------
        Class<?> carClazz = Class.forName("com.xingej.jichu.reflect.example1.BezCar");

        // 创建实例对象
        Car carType = (Car) carClazz.newInstance();

        carType.move();

    }

    public void testSwitch() {
        String clazz = "";

        switch (clazz) {
        case "A":

            break;
        case "B":

            break;
        case "c":

            break;

        case "d":

            break;

        case "e":

            break;

        case "f":

            break;

        default:
            break;
        }

    }

}

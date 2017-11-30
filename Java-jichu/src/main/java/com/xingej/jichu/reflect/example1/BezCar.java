package com.xingej.jichu.reflect.example1;

public class BezCar implements Car {

    private String name = "laoxing";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println("------奔驰-------");
    }

}

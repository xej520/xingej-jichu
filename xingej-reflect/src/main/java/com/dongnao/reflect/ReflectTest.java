package com.dongnao.reflect;

/**
 * 反射测试
 * 
 * @author erjun 2018年1月1日 上午9:49:20
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        String aa = "国家图书馆!";
        // 1、实例化对象.getClass()
        Class clazz1 = aa.getClass();

        // 2、类.class
        Class clazz2 = String.class;

        // 3、Class.forName("") 写全
        Class clazz3 = Class.forName("java.lang.String");

    }
}

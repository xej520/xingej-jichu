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

        // 1、面试题？Class.forName是如何加载的？
        // 加载这个类的时候，这份字节码已经加载java虚拟机的内存缓存中了
        // 直接返回这个类的字节码，
        // 如果这份字节码没有加载到jvm缓存中的话，那么，此刻，会调用类加载器
        // 去加载这个java类，返回字节码
        // 因此，如果forName没有在jvm中的内存缓存中，没有找到字节码的话
        // 会通过classLoader进行加载

        // 2、面试题？clazz1, clazz2, clazz3是否同一份呢呢？
        // 是啊
        //
        System.out.println("--->:\t" + (clazz1 == clazz2));// true
        System.out.println("--->:\t" + (clazz2 == clazz3));// true
        System.out.println("--->:\t" + (clazz1 == clazz2));// true

        System.out.println("--->:\t" + (Integer.class == int.class)); // false
        System.out.println("--->:\t" + (Integer.TYPE == int.class)); // true

        // 3、判断是否是基本类型
        Class intType = int.class;
        System.out.println("--->:\t" + intType.isPrimitive());// true

        Class stringType = String.class;
        System.out.println("--->:\t" + stringType.isPrimitive());// false
                                                                 // ,说明String不是基本类型哦

    }
}

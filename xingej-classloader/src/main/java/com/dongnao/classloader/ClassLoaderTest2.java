package com.dongnao.classloader;

/**
 * 打印出加载ClassLoaderTest2 这个类的加载器，
 * 
 * 并且打印出，父类加载器
 * 
 * @author erjun 2017年12月31日 下午4:49:50
 */
public class ClassLoaderTest2 {
    public static void main(String[] args) {
        ClassLoader loader = ClassLoaderTest2.class.getClassLoader();

        while (null != loader) {
            System.out.println(loader.getClass().getName());
            // 获得父类加载器
            loader = loader.getParent();
        }

        // 第3个就是由C++编写的嵌入到虚拟机JVM，随JVM一起启动的
        // java是获取不到的
        System.out.println(loader);
    }
}

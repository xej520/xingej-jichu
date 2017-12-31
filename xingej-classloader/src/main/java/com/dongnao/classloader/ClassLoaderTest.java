package com.dongnao.classloader;

public class ClassLoaderTest {
    public static void main(String[] args) {
        // 我们现在要将这个文件加载到JVM(虚拟机)，而且
        // 我们要得到加载这个文件的类加载的名字
        String className = ClassLoaderTest.class.getClassLoader().getClass().getName();

        System.out.println("----类加载的名字----:\t" + className);

    }
}

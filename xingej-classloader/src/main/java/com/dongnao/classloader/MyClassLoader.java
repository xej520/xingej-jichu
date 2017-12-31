package com.dongnao.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 自定义classLoader， 类加载我们制定的路径，避开父委托机制，
 * 
 * 我们的目的是将打乱顺序数的字节码还原之后，调用实例，方法
 * 
 * 暗含类字节加密的方法
 * 
 * @author erjun 2017年12月31日 下午6:47:31
 */
public class MyClassLoader extends ClassLoader {
    private String classDir;

    // 当你重写了构造器的话，最好把
    // 默认的构造器，显示出来，
    public MyClassLoader() {
    }

    public MyClassLoader(String classDir) {
        this.classDir = classDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 这里是执行父类的jdk提供的AppClassLoader不执行这个findClass
        // return super.findClass(name);
        String classFileName = classDir + "\\" + name.substring(name.lastIndexOf("\\") + 1) + ".class";
        // 文件输入流，兑入这个源目录读取字节码
        try {
            // 定义一个输入流
            FileInputStream fis = new FileInputStream(classFileName);
            // 字节数组输出流
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            // 解密
            cypher(fis, bos);
            fis.close();

            System.out.println("---这里进入了我们自定义类加载器MyClassLoader里面的重写的findClass方法-----");
            byte[] bytes = bos.toByteArray();

            // 返回Class的实例
            // 第一个参数，不知道是啥，所以，给了一个null；没事，不影响
            return defineClass(null, bytes, 0, bytes.length);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        // 指定一个参数，源目录
        String srcPath = args[0];
        // 指定一个参数，目标目录
        String destDir = args[1];
        // 文件输入流，兑入这个源目录读取字节码
        FileInputStream fis = new FileInputStream(srcPath);
        // 原目标中的文件名称拿出来
        String destFileName = srcPath.substring(srcPath.lastIndexOf("\\") + 1);
        String destPath = destDir + "\\" + destFileName;

        FileOutputStream fos = new FileOutputStream(destPath);
        // 开始加密
        cypher(fis, fos);
        // 先关闭，输入源的
        fis.close();
        // 再关闭，输出流的
        fos.close();

    }

    // 加密算法:异或加密算法

    // 这个方法，即可以做加密，也可以做解密，因为解密时，也是跟0xff 进行异或，异或两次，就回到原先的值了
    /**
     * (0000 1101)^ (1111 1111) = 1111 0010
     * 
     * @param ips
     *            输入流里，包含要被加密的字节码
     * @param ops
     */
    private static void cypher(InputStream ips, OutputStream ops) throws Exception {
        int b = -1; // 刚开始默认为-1， 什么也没有读到

        while ((b = ips.read()) != -1) {
            ops.write(b ^ 0xff);// 0xff 16进制，就是1111 1111
        }

    }

}

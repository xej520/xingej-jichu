package com.dongnao.classloader;

import java.util.Date;

/**
 * 测试自定义类加载器
 * 
 * @author erjun 2018年1月1日 上午6:19:20
 */
public class ClassTest {
    public static void main(String[] args) throws Exception {
        // 小知识
        Class clazz = new MyClassLoader("E:\\Project\\xingej\\xingej-jichu\\xingej-classloader\\destClass")
                .loadClass("ClassAttachment");

        // 不能用下面的形式，因为ClassAttachment 已经被打乱了，只能用父类Date去接收
        // ClassAttachment ca = (ClassAttachment) clazz.newInstance();

        // 这里是因为这个字节码被打乱了ClassAttachment类型是没办法接收返回的实例的
        Date date = (Date) clazz.newInstance();

        System.out.println(date.toString());
    }
}

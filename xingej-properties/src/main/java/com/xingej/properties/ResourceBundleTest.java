package com.xingej.properties;

import java.util.ResourceBundle;

/**
 * 测试ResourceBundle类
 * 
 * 就是用来读取属性文件，类似于Properties
 * 
 * 但是，要比Properties 这个简单
 * 
 * 基于类读取属性文件：该方法将属性文件当作类来处理，属性文件放在包中，使用属性文件的全限定性而非路径来指代文件
 * 
 * @author erjun
 * 2018年2月9日 下午4:12:11
 */
public class ResourceBundleTest {
    public static void main(String[] args) {
        //就是文件的名称而已
        ResourceBundle application = ResourceBundle.getBundle("application");
        
        String localCharset = application.getString("local.charset");
        
        String SERVLET_HDFS_PORT = application.getString("server.port");
        
        System.out.println("=====>:\t" + localCharset);
        
        System.out.println("=====>:\t" + SERVLET_HDFS_PORT);
    }
}

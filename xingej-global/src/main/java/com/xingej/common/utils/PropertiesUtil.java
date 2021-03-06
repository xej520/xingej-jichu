package com.xingej.common.utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    public static String getValue(String name) {
        InputStream io = null;
        
        Properties properties = new Properties();
       
        try {
            
            io = Class.forName("com.xingej.common.utils.PropertiesUtil").getClassLoader().getResourceAsStream("config.properties");
            
            //其实，是将io流包装成Propertie对象
            properties.load(io);
            
            io.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return properties.getProperty(name);
    }
    
    public static void main(String[] args) {
        System.out.println(PropertiesUtil.getValue("className"));
    }
}

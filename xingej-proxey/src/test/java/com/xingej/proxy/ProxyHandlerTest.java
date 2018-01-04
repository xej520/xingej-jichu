package com.xingej.proxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

import com.xingej.common.utils.PropertiesUtil;


public class ProxyHandlerTest {
    
    @Test
    public void test() throws Exception{
        //创建一个被代理对象
        Person person = new ZhangSan();
        
        //创建代理对象
        //说明：处理类是可以动态变化的，
        //从而使得，代理对象，也再不断变化
        // 也就是说，前两个参数是固定的，
        // 第3个参数可以动态变化，如通过配置文件读取
        //
        Person proxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, 
                new ProxyHandler(person));
        
        //说明，proxy是代理对象，代理person
        // 或者你可以这么认为
        // person是演员，而proxy是经纪人
       
        proxy.eat();
    }
    
    @Test
    public void test2() throws Exception{
        //创建一个被代理对象

        String className = PropertiesUtil.getValue("className");
        System.out.println("---className----:\t" + "com.xingej.proxy." + className);
        
        //利用反射，创建对象
        Person person = (Person) Class.forName("com.xingej.proxy." + className).newInstance();
        
        //创建代理对象
        //说明：处理类是可以动态变化的，
        //从而使得，代理对象，也再不断变化
        // 也就是说，前两个参数是固定的，第3个参数
        Person proxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, 
                new ProxyHandler(person));
        
        //说明，proxy是代理对象，代理person
        // 或者你可以这么认为
        // person是演员，而proxy是经纪人
       
        proxy.eat();
    }
    

    
    
}

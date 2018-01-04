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
    

    
    
}

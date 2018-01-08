package com.xingej.defineproxy;

import java.lang.reflect.Method;

import com.xingej.proxy.Person;

/**
 * 仿照的是处理类，如ProxyHandler
 * 
 * 实际执行的动态代理对象
 * 
 * @author erjun
 * 2018年1月4日 下午4:39:10
 */
public class MyProxyHandler implements MyInvocationHandler{

    private Person person;
    
    public MyProxyHandler(Person person) {
        this.person = person;
    }
    
    
    @Override
    public Object invoke(Object proxy, Method method, Object obj) throws Throwable {
        
        before();
        method.invoke(person, null);
        after();
        return null;
    }

    private void before() {
        System.out.println("---自定义---要做饭了，你喜欢吃什么------");
    }
    
    private void after() {
        System.out.println("---自定义---吃完了，该收拾一下了-----");
    }
    
    
}

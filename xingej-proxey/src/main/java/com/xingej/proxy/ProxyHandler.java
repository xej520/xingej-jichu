package com.xingej.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * 执行类
 * 
 * @author erjun
 * 2018年1月4日 上午9:06:57
 */
public class ProxyHandler implements InvocationHandler{
    //传入接口对象
    //其实，就是被代理的对象吧
    Person person = null;
    
    public ProxyHandler(Person person) {
        this.person = person;
    }
    
    
    /**
     * 看到的具体执行方法
     * 
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        
        method.invoke(person, null); //因为Person里的所有方法，都没有参数，因此，这里可以直接改成null
        
        after();
        
        return null;
    }

    private void before() {
        System.out.println("---要做饭了，你喜欢吃什么------");
    }
    
    private void after() {
        System.out.println("---吃完了，该收拾一下了-----");
    }
}

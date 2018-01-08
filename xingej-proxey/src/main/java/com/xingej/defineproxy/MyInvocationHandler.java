package com.xingej.defineproxy;

import java.lang.reflect.Method;

/**
 * 仿照的是JDK的InvocationHandler
 * 
 * 自定义的动态处理接口
 * 
 * 规范我们处理类的行为
 * 
 * @author erjun
 * 2018年1月4日 下午4:35:51
 */
public interface MyInvocationHandler {
    public Object invoke(Object proxy, Method method, Object obj) throws Throwable;
}

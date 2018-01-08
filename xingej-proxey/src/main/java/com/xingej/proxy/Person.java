package com.xingej.proxy;
/**
 * 目标类的接口
 * 
 * 约束目标类的行为
 * 
 * @author erjun
 * 2018年1月4日 上午8:38:06
 */
public interface Person {
    // 下面三个方法是，规范目标类的行为
    
    void eat() throws Throwable;
    
    void sleep() throws Throwable;
    
    void hit() throws Throwable;
}

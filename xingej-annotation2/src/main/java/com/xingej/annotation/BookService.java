package com.xingej.annotation;

/**
 * 使用注解测试
 * 
 * @author erjun
 * 2018年2月14日 下午8:07:05
 */

@CacheResult(key="book", cacheName="bookservice")
public class BookService {
    
    private static int i = 1;
    
    @CacheResult(key="method-key", cacheName="method-cn")
    public int getOrderAmount(){
        return i++;
    }
}

package com.xingej.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 测试注解，声明的是一个注解
 * 
 * @author erjun
 * 2018年2月14日 下午7:37:51
 */

//设置生命周期
@Retention(RetentionPolicy.RUNTIME)
//设置运行范围
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface CacheResult {
    //缓存键值
    String key();
    
    //缓存名称
    String cacheName();
    
    //有默认值是说，在初始化CacheResult注解时，可以不用初始化backupCacheName, needBloomFilter
    //这两个成员值
    //备份缓存名称
    String backupCacheName() default "";
    
    //是否需要布隆过滤器
    boolean needBloomFilter() default false;
    
    //是否需要分布式锁
    boolean needLock() default false;
}

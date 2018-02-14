package com.xingej.annotation;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Test;
/**
 * 以JDK方式来获取注解信息
 * 
 * @author erjun
 * 2018年2月14日 下午8:33:06
 */
public class JDKReflectTest {

    @Test
    public void testAnno() {
        Class<BookService> clazz = BookService.class;
        Class<CacheResult> annoClazz = CacheResult.class;
        
        if (clazz.isAnnotationPresent(annoClazz)) {
            CacheResult annotation = clazz.getAnnotation(annoClazz);
            System.out.println(annotation.key());
            System.out.println(annotation.cacheName());
        }
        
        Method[] methods = clazz.getMethods();
        for(Method method : methods) {
            if (method.isAnnotationPresent(annoClazz)) {
                CacheResult annotation = method.getAnnotation(annoClazz);
                System.err.println(annotation.key());
                System.err.println(annotation.cacheName());
            }
        }
        
        
    }

}

package com.xingej.annotation;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.AnnotationUtils;

public class SpringAnnotationContext implements ApplicationContextAware, ApplicationListener<ContextRefreshedEvent>{
    
    ApplicationContext applicationContext;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Class<CacheResult> crClass = CacheResult.class;
        Map<String, Object> annotations = applicationContext.getBeansWithAnnotation(crClass);
        
        Set<Entry<String, Object>> entrySet = annotations.entrySet();
        for(Entry<String, Object> entry : entrySet) {
            String beanId = entry.getKey();//获取bean的名称
            
            //获取bean的类对象
            Class<? extends Object> clazz = entry.getValue().getClass();
            System.out.println(beanId);
            System.out.println(clazz.getName());
            
            //参数注解类实例
            CacheResult cr = AnnotationUtils.findAnnotation(clazz, crClass);
            System.out.println(cr.key());
            System.out.println(cr.cacheName());
            
            //循环当前类的方法
            Method[] methods = clazz.getMethods();
            for(Method method : methods) {
                CacheResult methodCr = AnnotationUtils.findAnnotation(clazz, crClass);
                if (null != methodCr) {
                    System.out.println(methodCr.key());
                    
                    
                }
                
                
                
            }
            
        }
        
    }

    //通过这个方法，来获取上下文applicationContext，说明
    //SpringAnnotationContext类，也具有了容器的能力
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}

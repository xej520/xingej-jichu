package com.xingej.jichu.hashmap;
/**
 * 自定义hashmap, 仿jdk原生的hashmap
 * 
 * @author erjun
 * 2018年1月15日 下午3:44:02
 */
public interface MyMap<K,V> {
   V put(K key, V value);
   
   V get(K key);
   
   int size();
   

   //定义一个内部接口
   interface Entry<K, V>{
       K getKey();
       
       V getValue();
   }
    
}

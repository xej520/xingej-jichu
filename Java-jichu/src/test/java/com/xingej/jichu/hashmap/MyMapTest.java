package com.xingej.jichu.hashmap;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyMapTest {

    @Test
    public void test() {
        MyHashMap<String, Object> map = new MyHashMap<>();
        
        map.put("jack", "bj");
        map.put("star", 19);
//        map.put("sex", "male");
//        map.put("school", "bjtu");
        
        System.out.println("---->:\t" + map.get("jack"));
    
    }

    @Test
    public void testHashCode(){
        
        String name = "laoxi";
        
        System.out.println("----->:\t" + name.hashCode());
    }
    
    @Test
    public void testHash() {
        String[] hello="Hello lao Hello ".split(" ");  
         System.out.println(hello[0].hashCode());  
        System.out.println(hello[1].hashCode());  
        System.out.println(hello[2].hashCode());  
    }
    
    @Test
    public void testYiWei(){
        //往右移动是增加
        System.out.println("----->:\t" + (1 << 4));  //16
    }
    
    @Test
    public void testYiWei2(){
        //往右移动是增加
        System.out.println("----->:\t" + (16 >> 4)); //1  
    }
}

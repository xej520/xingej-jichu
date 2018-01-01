package com.dongnao.reflect;

import java.util.Collection;

import com.dongnao.reflect.utils.PropertiesUtil;

public class IocDemo {
    public static void main(String[] args) throws Exception{
        Collection collection = (Collection)Class.forName(PropertiesUtil.getValue("className")).newInstance();
        
        collection.add("spark");
        collection.add("spark2");
        collection.add("spark6");
        
        System.out.println("--->:\t"+ collection.size());
    
        
    }
}

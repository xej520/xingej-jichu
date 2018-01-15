package com.xingej.jichu.hashmap;

public class MyHashMap<K, V> implements MyMap<K, V>{
    
    //数组的长度是2的倍数
    //JDK里，默认也是16
    private static Integer defaultLength = 16;
    
    //负载因子
    private static double defaultLoad = 0.75;
    
    private Entry<K, V>[] table = null;
    
    //size记录数组的元素个数的
    private int size = 0;
    
    public MyHashMap(int defaultLength, double defaultLoad) {
        this.defaultLength = defaultLength;
        this.defaultLoad = defaultLoad;
    
        table = new Entry[this.defaultLength];
        
    }
    
    public MyHashMap() {
        this(defaultLength, defaultLoad);
    }
    
    //定义一个hash函数
    private int getIndex(K key){
        //取模法
        int m = this.defaultLength - 1;
        
        System.out.println("====key.hashCode()====:\t" + key.hashCode());
        
        return key.hashCode() % m;
        
    }
    
    @Override
    public V put(K key, V value) {
        //1、根据key和hash函数，取到数组中的下标
        int index = this.getIndex(key);
        System.out.println("=====index======:\t "+ index);
        //2、根据这个下标判断该位置是否有数据
        Entry<K, V> entry = table[index];
        
        if (null == entry) {
            table[index] = new Entry(key, value, null, index);
            size++;
        } else {
            //将旧的entry 对象，存储到新的next里
            Entry<K, V> newEntry = new Entry(key, value, entry, index);
       
            //再将新的newEntry存储到旧的index里
            table[index] = newEntry;
        }
        
        return  table[index].getValue();
    }

    @Override
    public V get(K key) {
        //1、根据key和hash函数，取到数组中的下标
        int index = this.getIndex(key);
        
        //2、根据这个下标判断该位置是否有数据
        Entry<K, V> entry = table[index];
        
        return entry == null ? null : entry.getValue();
    }

    @Override
    public int size() {
        return size;
    }
    
    //定义一个内部类
    class Entry<K, V> implements MyMap.Entry<K, V>{

        K key;
        V value;
        
        Entry<K, V> next;//指向下一个元素
        
        //记录此Entry对象在hash表中的下标
        int index;
        
        public Entry(K k, V v, Entry<K, V> n, int inx) {
            key  = k;
            value = v;
            index = inx;
            next = n;
        }
        
        
        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
        
    }
    
    
}

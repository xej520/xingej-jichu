package com.xingej.thread.multiProducerConsumer2;
/**
 * 生产类
 * 
 * 不断的去生产，那么让我们联想到应该是一个线程类
 * 
 * @author erjun
 * 2018年1月17日 上午9:18:17
 */
public class Producer implements Runnable{
    //持有对方的引用
    private Resource resource;
    
    public Producer(Resource resource) {
        this.resource = resource;
    }
    
    @Override
    public void run() {
        //不断去生产
        while(true){
            resource.set("Apple X");
        }
    }
    
    
    
}

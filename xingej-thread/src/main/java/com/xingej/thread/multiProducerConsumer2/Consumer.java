package com.xingej.thread.multiProducerConsumer2;
/**
 * 多消费者
 * 
 * 不断的去消费，那么让我们联想到应该是一个线程类
 * 
 * @author erjun
 * 2018年1月17日 上午9:18:17
 */
public class Consumer implements Runnable{
    //持有对方的引用
    private Resource2 resource;
    
    public Consumer(Resource2 resource) {
        this.resource = resource;
    }
    
    @Override
    public void run() {
        //不断去消费
        while(true){
            resource.out();
        }
    }
    
    
    
}

package com.xingej.thread.multiProducerConsumer2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多生产者，消费者模式
 * 资源类
 * 
 * @author erjun
 * 2018年1月17日 上午9:01:08
 */
public class Resource {
    //商品名称
    private String name;
    //商品编号
    private int id = 1;
    //是否有商品
    private boolean hasGoods = false; //默认是没有商品
    
    //引入一个Lock
    private Lock lock = new ReentrantLock();
    
    //属于这个锁的监控器对象Condition
    private Condition condition = lock.newCondition();
    
    //生产方法
    public void set(String name){
        lock.lock();
        
        try {
            
            while (hasGoods) {
                try {

                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            this.name = name + "_" + id;
            id++;
            
            System.out.println("---生产线程名称---:\t" + Thread.currentThread().getName() + ", 以生产商品为:" + this.name);
            
            hasGoods = true; //表示有商品了
            
            condition.signalAll();
            
        }finally {
            lock.unlock();
        }
       
    }
    
    
    // 消费方法
    public void out(){
        
        lock.lock();
        
        try {
            
            while (!hasGoods) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            System.out.println("---消费线程名称---:\t" + Thread.currentThread().getName() + ", 已经消费商品为:" + this.name);
            
            //设置为无商品标志
            hasGoods = false; 

            condition.signalAll();
            
        } finally {
            lock.unlock();
        }
    }
    
}

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
public class Resource2 {
    //商品名称
    private String name;
    //商品编号
    private int id = 1;
    //是否有商品
    private boolean hasGoods = false; //默认是没有商品
    
    //引入一个Lock
    private Lock lock = new ReentrantLock();
    
    //属于这个锁的监控器对象Condition
    //pro_condition、cus_condition同属于lock
    //生产者监控对象
    private Condition pro_condition = lock.newCondition();
    //消费者监控对象
    private Condition cus_condition = lock.newCondition();
    
    //因为我们在调用的时候，是T0，T1调用生产方法，自然这两个线程就是生产者的线程
    //生产方法
    public void set(String name){
        lock.lock();
        
        try {
            
            while (hasGoods) {
                try {
                    //当有产品时，就通知生产者线程，进入阻塞状态，先别在生产了
                    pro_condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            //生产者线程，开始生产产品
            this.name = name + "_" + id;
            id++;
            
            System.out.println("---生产线程名称---:\t" + Thread.currentThread().getName() + ", 以生产商品为:" + this.name);
            
            hasGoods = true; //表示有商品了
            
            //然后，通知，消费者线程，开始消费产品
            cus_condition.signalAll();
            
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
                    //当没有产品时，消费者线程，就进入阻塞状态
                    cus_condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            //消费者线程，消费产品
            System.out.println("---消费线程名称---:\t" + Thread.currentThread().getName() + ", 已经消费商品为:" + this.name);
            
            //设置为无商品标志
            hasGoods = false; 

            //消费完产品后，就通知生产者线程，开始生产产品
            pro_condition.signalAll();
            
        } finally {
            lock.unlock();
        }
    }
    
}

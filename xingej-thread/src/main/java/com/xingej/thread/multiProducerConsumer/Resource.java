package com.xingej.thread.multiProducerConsumer;
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
    
    //生产方法
    public synchronized void set(String name){
        while (hasGoods) {
            try {
                //如果有商品的话，就在这里阻塞着，直到消费者消费了商品
                this.wait();
                //阻塞结束后，再进行判断一次
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
        
        //通知消费线程，来消费
        notify(); //通知其他线程
    }
    
    
    // 消费方法
    public synchronized void out(){
        while (!hasGoods) {
            try {
                //如果没有商品的话，就在这里阻塞着，直到生产者生产了商品
                this.wait();
                //阻塞结束后，再进行判断一次
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("---消费线程名称---:\t" + Thread.currentThread().getName() + ", 已经消费商品为:" + this.name);
        
        //设置为无商品标志
        hasGoods = false; 
        
        //通知消费线程，来消费
        notify(); //通知生产者来生产产品
    }
    
}

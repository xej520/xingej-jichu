package com.xingej.jichu.luan;
/**
 * 求出一年的毫秒数啊
 * 
 * @author erjun
 * 2018年1月18日 下午7:05:54
 */
public class 一年的毫秒数 {
    public static void main(String[] args) {
        // 求一年的毫秒数，这是错误的，已经超过int类型的最大值了
        // 默认是int32运算，其次int32_t不够存储
        System.out.println("======>:\t" + 365 * 24 * 60 * 60 * 1000);

        //因此，必须添加L
        System.out.println("======>:\t" + 365 * 24 * 60 * 60 * 1000L);
        
        System.out.println("======>:\t" + 365 * 24 * 60 * 60 * 1000l);
    }
}

package com.xingej.uniqueID.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * JVM的原子操作
 * 
 * @author erjun
 * 2018年1月18日 下午2:16:50
 */
public class OrderAtomicServiceImpl implements OrderServer{

    static AtomicInteger atomicInteger = new AtomicInteger();
    
    public String getOrderNo() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYmmDDHHMMSS");
        return simpleDateFormat.format(new Date()) + atomicInteger.incrementAndGet();
    }
    
}

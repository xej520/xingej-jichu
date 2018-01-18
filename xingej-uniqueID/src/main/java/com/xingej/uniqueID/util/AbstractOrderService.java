package com.xingej.uniqueID.util;

import java.text.SimpleDateFormat;
import java.util.Date;

//定义抽象类
public abstract class AbstractOrderService implements OrderServer{
    
    static int num;
    
    public static String getOrderNo2(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYmmDDHHMMSS");
        System.out.println("-------------------父类-------");
        return simpleDateFormat.format(new Date()) + num++;
    }
    
    public String getOrderNo() {
        return getOrderNo2();
    }
}

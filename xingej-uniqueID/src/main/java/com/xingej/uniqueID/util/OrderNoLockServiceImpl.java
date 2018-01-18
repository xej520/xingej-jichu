package com.xingej.uniqueID.util;

import java.text.SimpleDateFormat;
import java.util.Date;

//无锁方式
public class OrderNoLockServiceImpl implements OrderServer{

    int num;
    
    @Override
    public String getOrderNo() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYmmDDHHMMSS");
        return simpleDateFormat.format(new Date()) + num++;
    }
    
}

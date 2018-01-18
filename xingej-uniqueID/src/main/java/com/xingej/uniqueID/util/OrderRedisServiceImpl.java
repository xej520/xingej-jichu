package com.xingej.uniqueID.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class OrderRedisServiceImpl implements OrderServer{
    
    static JedisPool jedisPool;
    
    static {
        jedisPool = new JedisPool(new JedisPoolConfig(),"192.168.1.102",6379,1000,"mima");
    }
    
    @Override
    public String getOrderNo() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYmmDDHHMMSS");
        return simpleDateFormat.format(new Date()) + jedisPool.getResource().incr("order_key");
    }
    
}

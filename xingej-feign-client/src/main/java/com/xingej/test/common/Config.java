package com.xingej.test.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {
    public static String ENDPOINT ;
    
    private static final Object ENDPOINT_LOCK = new Object();
    
    @Value("${api.endpoint}")
    private void setENDPOINT(String eNDPOINT){
        synchronized (ENDPOINT_LOCK) {
            
            System.out.println("---------------->:\t" + eNDPOINT);
            
            ENDPOINT = eNDPOINT;
        }
    }
}

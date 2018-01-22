package com.xingej.test.service;

import com.alibaba.fastjson.JSONObject;
import com.xingej.feign.apiV1.Dcos;
import com.xingej.feign.apiV1.DcosClient;
import com.xingej.test.common.Config;

public class LoginServiceImpl {
    
    public void login(){
        
        if (null == Config.ENDPOINT) {
            
            System.out.println("================");
            
            return ;
        }
        
        Dcos dcos = DcosClient.getInstance(Config.ENDPOINT);
        
        if (null == dcos) {
            return ;
        }
        
       JSONObject result = dcos.login("laoxing", "123456");
       
       System.out.println("---->:\t" + result.toJSONString());
    
    }
}

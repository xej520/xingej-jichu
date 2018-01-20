package com.xingej.test.service;

import com.alibaba.fastjson.JSONObject;
import com.xingej.feign.apiV1.Dcos;
import com.xingej.feign.apiV1.DcosClient;

public class LoginServiceImpl {
    
    public void login(){
        
        Dcos dcos = DcosClient.getInstance("http://localhost:8080");
        
        if (null == dcos) {
            return ;
        }
        
       JSONObject result = dcos.login("laoxing", "123456");
       
       System.out.println("---->:\t" + result.toJSONString());
    
    }
}

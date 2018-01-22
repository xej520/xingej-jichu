package com.xingej.test.service;

import com.alibaba.fastjson.JSONObject;
import com.xingej.test.common.DcosHelper;

public class FtpClusterServiceImpl {
    
    public void show(){
        
        JSONObject result = DcosHelper.getInstance().show();
        
        System.out.println("=====验证：GET请求，无参数情况====:\t" + result.toJSONString());
    }
}

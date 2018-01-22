package com.xingej.test.common;

import com.xingej.feign.apiV1.Dcos;
import com.xingej.feign.apiV1.DcosClient;

//类似于静态工具类
public class DcosHelper {
    
    //声明私有构造方法
    private DcosHelper(){
        
    }
    
    public static  Dcos getInstance(){
        return DcosClient.getInstance(Config.ENDPOINT);
    }
}

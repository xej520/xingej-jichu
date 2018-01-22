package com.xingej.feign.apiV1;

import com.alibaba.fastjson.JSONObject;

import feign.Param;
import feign.RequestLine;

/**
 * 定义提供API的接口
 * 
 * @author erjun
 * 2018年1月19日 下午2:43:50
 */

//可以添加abstract ，也可以不加的
// 接口的名字，你可以随便叫
// 这里称为Dcos，主要是结合我们的项目来的
public abstract interface Dcos {
    @RequestLine("GET /login?username={username}&password={password}")
    public abstract JSONObject login(@Param("username") String username, @Param("password") String password);

    @RequestLine("GET /show")
    public abstract JSONObject show();
}

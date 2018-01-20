package com.xingej.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xingej.test.model.ApiResult;
import com.xingej.test.util.EntityUtil;

@Controller
public class LoginController {
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject login(String username, String password){
    
        ApiResult apiResult = new ApiResult();
        
        System.out.println("===============================");
        
        Map<String, String> map = new HashMap<String, String>();
        
        map.put("username", username);
        map.put("password", password);
        
        apiResult.setData(JSONObject.toJSONString(map));
        
        apiResult.setMessage("成功了！");
        
        apiResult.setResult(true);
        
        System.out.println("-------->:\t" + JSON.toJSONString(apiResult));
        
        System.out.println("-------->:\t" + EntityUtil.toJsonObject(apiResult));
        
        return EntityUtil.toJsonObject(apiResult);
    }
    
    
    
}   

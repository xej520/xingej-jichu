package com.xingej.test.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class EntityUtil {
    
    private static Logger logger = LoggerFactory.getLogger(EntityUtil.class);
    
    //将对象，转换成JSON格式
    public static JSONObject toJsonObject(Object object) {

        String json = null;
        
        if (object instanceof String) {
            json = object.toString();
        } else {
            json = JSON.toJSONString(object);
        }
        
        JSONObject jsonObj = new JSONObject();
        
        if (StringUtils.isEmpty(json) || !json.startsWith("{")) {
            return jsonObj;
        }
        
        try {
            jsonObj = JSON.parseObject(json);
        } catch (Exception e) {
            logger.error("json转换失败，不是正确的json格式，json ： " + json, e);
        }

        return jsonObj;
    }
}

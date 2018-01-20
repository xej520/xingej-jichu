package com.xingej.feign.utils;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ModelUtils {
    public static final Gson GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").setPrettyPrinting()
            .disableHtmlEscaping().create();

    public static String toString(Object o) {
        return JSON.toJSONString(o);
    }
}
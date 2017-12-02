package com.xingej.jichu.json;

import java.util.Date;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

public class JSONTest {

    // 构建JSON对象的方式一
    // 直接new JSONObject, 使用put添加属性
    @Test
    public void test() {
        JSONObject wangxiaoer = new JSONObject();

        wangxiaoer.put("name", "王小二");
        wangxiaoer.put("age", 29);
        wangxiaoer.put("birthday", new Date());
        wangxiaoer.put("school", "蓝翔");
        wangxiaoer.put("major", new String[] { "理发", "挖掘机" });
        wangxiaoer.put("has_girlfriend", false);
        wangxiaoer.put("car", null);

        System.out.println("====>:\t" + wangxiaoer.toString());

    }

}

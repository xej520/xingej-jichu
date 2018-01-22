package com.xingej.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xingej.test.model.ApiResult;
import com.xingej.test.util.EntityUtil;

@Controller(value = "/clusters")
public class FtpClusterController {

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject showInfo() {

        ApiResult apiResult = new ApiResult();

        Map<String, Object> allBooks = new HashMap<String, Object>();
        allBooks.put("bookname", "Java核心技术");
        allBooks.put("price", 89.0);
        allBooks.put("type", "Java");
        allBooks.put("auth", "laoxing");

        apiResult.setData(allBooks);
        apiResult.setMessage("获取成功");
        apiResult.setResult(true);

        System.out.println("-------->:\t" + EntityUtil.toJsonObject(apiResult));

        return EntityUtil.toJsonObject(apiResult);
    }
}

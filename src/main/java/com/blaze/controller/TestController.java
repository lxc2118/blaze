package com.blaze.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.blaze.biz.Proxy;

@Controller
@RequestMapping("/mvc")
public class TestController {
 
    @RequestMapping("/hello")
    public String hello(){ 
    	
        return "index";
    }
    
    @ResponseBody
    @RequestMapping("/hello1")
    public Object hello1() {
    	Proxy proxy = new Proxy();
    	proxy.setId(1l);
    	proxy.setAddress("address");
    	JSONObject obj = new JSONObject();
    	obj.put("1", "2");
    	obj.put("2", null);
    	obj.put("3", new Date());
    	return JSON.toJSONString(obj,SerializeConfig.globalInstance, null, "yyyy-MM-dd HH:mm:ss",JSON.DEFAULT_GENERATE_FEATURE);
    }
    
    @ResponseBody
    @RequestMapping("/hello2")
    public Object proxy() {
    	List<Proxy> list = new ArrayList<>();
    	Proxy p1 = new Proxy();
    	p1.setId(1l);
    	p1.setAddress("address1");
    	Proxy p2 = new Proxy();
    	p2.setId(1l);
    	p2.setAddress("address2");
    	list.add(p1);
    	list.add(p2);
    	return list;
    }
}
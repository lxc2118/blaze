package com.blaze.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    	proxy.setAddress("上海");
    	return proxy;
    }
    
    @ResponseBody
    @RequestMapping("/proxy")
    public Object proxy() {
    	List<Proxy> list = new ArrayList<>();
    	Proxy p1 = new Proxy();
    	p1.setId(1l);
    	p1.setAddress("上海");
    	Proxy p2 = new Proxy();
    	p2.setId(1l);
    	p2.setAddress("上海");
    	list.add(p1);
    	list.add(p2);
    	return list;
    }
}
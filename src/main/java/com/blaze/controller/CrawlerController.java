package com.blaze.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blaze.biz.Proxy;
import com.blaze.common.Paging;
import com.blaze.dao.ProxyDao;

import hcy.util.kit.JSONHelper;

@Controller
@RequestMapping("/crawler")
public class CrawlerController {

    @ResponseBody
	@RequestMapping("/list")
    public String hello(@PathVariable("p") Integer p){
    	
        return "";
    }
}

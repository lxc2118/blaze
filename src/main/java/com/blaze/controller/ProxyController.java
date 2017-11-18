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
@RequestMapping("/proxy")
public class ProxyController {
	
	@Resource
	private ProxyDao proxyDao;

    @ResponseBody
	@RequestMapping("/page/{p}")
    public String getPage(@PathVariable("p") Integer p){
    	Paging<Proxy> page = proxyDao.getPage(p);
    	String str = JSONHelper.toJSONStringWithDateFormat(page);
        return str;
    }
    
    @ResponseBody
	@RequestMapping("/del/{id}")
    public String del(@PathVariable("id") Long id){
    	Proxy proxy = proxyDao.get(id);
    	proxyDao.del(proxy);
        return JSONHelper.ok();
    }
    
}

package com.blaze.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blaze.biz.Proxy;
import com.blaze.dao.ProxyDao;

@Service("proxyService")
public class ProxyService {

	
	@Resource
	private ProxyDao proxyDao;

	public Proxy get(int id) {
		return proxyDao.get(id);
	}
}

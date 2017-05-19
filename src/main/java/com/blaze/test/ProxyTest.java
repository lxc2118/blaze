package com.blaze.test;

import com.blaze.crawler.Bug;
import com.blaze.crawler.XixiProxyCrawler;

import junit.framework.TestCase;

public class ProxyTest{

	public void test() {
		System.out.println(11);
//		Bug bug = new Bug();
//		bug.setUrl("http://www.xicidaili.com/nn/");
//		new XixiProxyCrawler(bug).crawl();
	}
	
	public static void main(String[] args) {
		Bug bug = new Bug();
		bug.setUrl("http://www.xicidaili.com/nn/");
		new XixiProxyCrawler(bug).crawl();
	}
}

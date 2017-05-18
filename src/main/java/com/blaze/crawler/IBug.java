package com.blaze.crawler;

/**
 * a bug for crawler to crawl 
 * 
 * @author lxc
 *
 */
public interface IBug {
	
	void setUrl(String url);
	String getUrl();
	
	void setDelay(Long time);
	Long getDelay();
}

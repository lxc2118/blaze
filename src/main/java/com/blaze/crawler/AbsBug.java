package com.blaze.crawler;

public abstract class AbsBug implements IBug{

	protected String url;
	
	protected Long delay;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getDelay() {
		return delay;
	}

	public void setDelay(Long delay) {
		this.delay = delay;
	}
	
	
}

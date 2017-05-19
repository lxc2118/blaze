package com.blaze.crawler;

import java.util.List;

public class BaseBug extends AbsBug{
	
	public BaseBug(String matchUrl) {
		this.matchUrl = matchUrl;
	}

	/**
	 * ∆•≈‰url
	 */
	private String matchUrl;
	
	public String getMatchUrl() {
		return matchUrl;
	}



	public void setMatchUrl(String matchUrl) {
		this.matchUrl = matchUrl;
	}



	public List<String> getUrls() {
		return null;
	}
	
}

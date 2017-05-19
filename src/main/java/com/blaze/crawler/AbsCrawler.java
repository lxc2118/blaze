package com.blaze.crawler;

import hcy.util.kit.http.HttpReq;

public abstract class AbsCrawler {
	
	public AbsCrawler(IBug bug){
		this.bug = bug;
	}

	protected IBug bug;

	public abstract void doCrawl();

	public void crawl() {
		if (bug.getDelay() != null && bug.getDelay() > 0) {
			try {
				Thread.sleep(bug.getDelay());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		doCrawl();
	}
	
	public String getHtml() {
		if (this.bug.getUrl()!=null) {
			return new HttpReq(this.bug.getUrl()).doExecute();
		}
		return "";
	}

}

package com.blaze.job;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import hcy.util.kit.http.HttpReq;



public class SpringQuartzTest extends QuartzJobBean {

	public void work() {
		System.out.println(new Date());
		String url = "http://www.xicidaili.com/nn/1";
		System.out.println(url);
        String html = new HttpReq(url).execute();
        System.out.println(html);
	}
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		this.work();
	}

}

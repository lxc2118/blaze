package com.blaze.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job{

	public void execute(JobExecutionContext context) throws JobExecutionException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = format.format(new Date());
		System.out.println(date);
		
//		String html = new HttpReq("https://caipiao.163.com/").execute();
//		Document doc = Jsoup.parse(html);
//		doc.select("")
	}

}

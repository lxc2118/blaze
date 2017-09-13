package com.blaze.test;

import javax.servlet.http.HttpServlet;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.blaze.job.MyJob;
import com.blaze.job.ProxyJob;


public class QuartZTest extends HttpServlet{

	public void init() {
		SchedulerFactory schedulerfactory = new StdSchedulerFactory();
		Scheduler scheduler = null;
		try {
			scheduler = schedulerfactory.getScheduler();
			JobDetail job = JobBuilder.newJob(ProxyJob.class).withIdentity("job1", "jgroup1").build();
			// Trigger
			// trigger=TriggerBuilder.newTrigger().withIdentity("simpleTrigger",
			// "triggerGroup")
			// .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(1).withRepeatCount(8))
			// .startNow().build();
			
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "triggerGroup")
					.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).startNow().build();
			scheduler.scheduleJob(job, trigger);
			scheduler.start();
			System.out.println("¶¨Ê±Æ÷Æô¶¯");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

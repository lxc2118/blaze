package quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import job.MyJob;

public class QuartzTest {

	public static void main(String[] args) {
		SchedulerFactory schedulerfactory = new StdSchedulerFactory();
		Scheduler scheduler = null;
		try {
			scheduler = schedulerfactory.getScheduler();
			JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("job1", "jgroup1").build();
			// Trigger
			// trigger=TriggerBuilder.newTrigger().withIdentity("simpleTrigger",
			// "triggerGroup")
			// .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(1).withRepeatCount(8))
			// .startNow().build();
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "triggerGroup")
					.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).startNow().build();
			Trigger trigger2 = TriggerBuilder.newTrigger().withIdentity("simpleTrigger2", "triggerGroup")
					.withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?")).forJob(job).startNow().build();

			scheduler.scheduleJob(job, trigger);
			scheduler.scheduleJob(trigger2);
			System.out.println(job.getKey().getName());
			System.out.println(job.getKey().getGroup());
			System.out.println(trigger.getKey().getName());
			System.out.println(trigger.getKey().getGroup());
			scheduler.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

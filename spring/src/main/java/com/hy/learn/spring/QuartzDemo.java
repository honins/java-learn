package com.hy.learn.spring;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author Created by hy
 * @date on 2019/11/15 9:49
 */
public class QuartzDemo {

    public static void main(String[] args) throws SchedulerException {
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        scheduler.start();
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("myjob", "myjobgroup")
                .usingJobData("job_param","job_param1")
                .build();
        Trigger trigger= TriggerBuilder.newTrigger()
                .withIdentity("mytrigger", "mytriggerGroup")
                .usingJobData("job_trigger_param", "job_trigger_param1")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ? 2019"))
                .build();

        scheduler.scheduleJob(jobDetail,trigger);

    }

}

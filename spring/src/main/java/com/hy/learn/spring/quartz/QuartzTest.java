package com.hy.learn.spring.quartz;

import org.quartz.*;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author Created by hy
 * @date on 2020/3/10 14:36
 *
 * https://www.w3cschool.cn/quartz_doc/quartz_doc-1xbu2clr.html
 *
 */
public class QuartzTest {

    public static void main(String[] args) {

        try {
            // Grab the Scheduler instance from the Factory
            SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();

            Scheduler scheduler = schedFact.getScheduler();

            // and start it off
            scheduler.start();
            // define the job and tie it to our HelloJob class
            JobDetail job = newJob(HelloJob.class)
                    .withIdentity("job1", "group1")
                    .usingJobData("jobSays", "Hello World!")
                    .usingJobData("myFloatValue", 3.141f)
                    .build();

            // Trigger the job to run now, and then repeat every 40 seconds
            Trigger trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
//                    .withSchedule(simpleSchedule()
//                            .withIntervalInSeconds(3)
//                            .repeatForever())
                    .withSchedule(cronSchedule("0/3 * * * * ?"))
                    .build();

            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(job, trigger);
            String jobData = scheduler.getJobDetail(new JobKey("job1","group1")).getJobDataMap().getString("jobSays");
            System.out.println(jobData);

            scheduler.getListenerManager().addSchedulerListener(new MySchedListener());
            Thread.sleep(10000);
            scheduler.shutdown();

        } catch (SchedulerException | InterruptedException se) {
            se.printStackTrace();
        }
    }

}

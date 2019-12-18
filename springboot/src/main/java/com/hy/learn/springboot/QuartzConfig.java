package com.hy.learn.springboot;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Created by hy
 * @date on 2019/11/15 10:49
 */
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail myJobDetail(){
        JobDetail jobDetail = JobBuilder.newJob(HiSpringbootJob.class)
                .withIdentity("myJob1","myJobGroup1")
                //JobDataMap可以给任务execute传递参数
                .usingJobData("job_param","job_param1")
                .storeDurably()
                .build();
        return jobDetail;
    }

    @Bean
    public Trigger myTrigger(){
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(myJobDetail())
                .withIdentity("myTrigger1","myTriggerGroup1")
                .usingJobData("job_trigger_param","job_trigger_param1")
                .startNow()
                //.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ? 2019"))
                .build();
        return trigger;
    }
}

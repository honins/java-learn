package com.hy.learn.spring.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author Created by hy
 * @date on 2020/3/10 15:09
 */
public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(">>>>>>>>>say hello!");
    }
}

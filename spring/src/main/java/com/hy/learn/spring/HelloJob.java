package com.hy.learn.spring;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author Created by hy
 * @date on 2019/11/15 9:46
 */
public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("hello:"+jobExecutionContext.getJobDetail().getKey());
    }
}

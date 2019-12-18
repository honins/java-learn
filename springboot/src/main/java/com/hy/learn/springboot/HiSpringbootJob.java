package com.hy.learn.springboot;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author Created by hy
 * @date on 2019/11/15 10:48
 */
public class HiSpringbootJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("hi HiSpringbootJob"+jobExecutionContext.getJobDetail().getKey());
    }
}

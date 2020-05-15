package com.hy.learn.springboot.learn.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

/**
 * @author Created by hy
 * @date on 2020/5/15 14:43
 */
public class RandIntCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String type = context.getEnvironment().getProperty("condition.rand.type");
        return "int".equalsIgnoreCase(type);
    }
}

package com.hy.learn.springboot.learn.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Created by hy
 * @date on 2020/5/15 14:45
 */
public class RandBooleanCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String type = context.getEnvironment().getProperty("condition.rand.type");
        return "boolean".equalsIgnoreCase(type);
    }
}

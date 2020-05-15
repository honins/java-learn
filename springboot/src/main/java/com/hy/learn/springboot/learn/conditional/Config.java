package com.hy.learn.springboot.learn.conditional;

import com.sun.org.apache.bcel.internal.classfile.ConstantNameAndType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author Created by hy
 * @date on 2020/5/15 14:29
 */
@Configuration
public class Config {

    private String randType;

    public String getRandType() {
        return randType;
    }

    public void setRandType(String randType) {
        this.randType = randType;
    }

    @Bean
    @Conditional(RandIntCondition.class)
    public RandDataComponent<Integer> randIntComponent() {
        return new RandDataComponent<>(() -> {
            Random random = new Random();
            return random.nextInt(1024);
        });
    }

//    @Bean
//    @Conditional(RandBooleanCondition.class)
//    public RandDataComponent<Boolean> randBooleanComponent() {
//        return new RandDataComponent<>(() -> {
//            Random random = new Random();
//            return random.nextBoolean();
//        });
//    }

}

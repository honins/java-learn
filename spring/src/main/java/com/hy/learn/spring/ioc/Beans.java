package com.hy.learn.spring.ioc;

import com.hy.learn.spring.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Created by hy
 * @date on 2021/2/23 15:57
 */
@Configuration
public class Beans {

    @Bean
    public User getUser() {
        User user = new User();
        user.setId(1);
        user.setName("aaa");
        return user;
    }

}

package com.hy.learn.spring.pojo;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;

import java.util.Date;

import static org.mockito.Mockito.*;

/**
 * @author Created by hy
 * @date on 2021/2/23 14:51
 */
public class UserTest {
    @Mock
    Date birthDate;
    @InjectMocks
    User user;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
package com.hy.learn.springboot.learn.controller;

import com.hy.learn.springboot.learn.conditional.RandDataComponent;
import com.hy.learn.springboot.learn.conditional.TestComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by hy
 * @date on 2020/5/15 14:54
 */
@RestController
@RequestMapping("/conditional")
public class ConditionalController {

    @Autowired
    private RandDataComponent randDataComponent;

    @Autowired
    private TestComponent testComponent;


    @GetMapping(path = "/show")
    public String show() {
        return randDataComponent.rand()+"";
//        return String.valueOf(testComponent.get());
    }

}

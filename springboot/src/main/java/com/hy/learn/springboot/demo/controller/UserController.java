package com.hy.learn.springboot.demo.controller;

import com.hy.learn.springboot.demo.common.CommonResult;
import com.hy.learn.springboot.demo.pojo.vo.UserVO;
import com.hy.learn.springboot.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by hy
 * @date on 2019/12/26 15:52
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "取用户信息")
    @GetMapping(value = "/info")
    public CommonResult<UserVO> getInfo(
        @RequestParam Integer id
    ){
        UserVO userVO = new UserVO();
        return CommonResult.success(userVO);
    }

}

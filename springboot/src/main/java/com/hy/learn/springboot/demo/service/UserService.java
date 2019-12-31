package com.hy.learn.springboot.demo.service;

import com.hy.learn.springboot.demo.pojo.SysUserDTO;

/**
 * @author Created by hy
 * @date on 2019/12/19 16:57
 */
public interface UserService {

    SysUserDTO getUser(String name, String password);

}

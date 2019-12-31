package com.hy.learn.springboot.demo.dao;

import com.wolwo.hospital.pojo.SysUserDTO;
import org.apache.ibatis.annotations.Param;

/**
 * @author Created by hy
 * @date on 2019/12/19 17:47
 */
public interface UserDao {

    SysUserDTO getUser(@Param("username") String username, @Param("password") String password);

    SysUserDTO getUser(Integer uid);

}

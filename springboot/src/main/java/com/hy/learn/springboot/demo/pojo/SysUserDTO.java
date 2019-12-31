package com.hy.learn.springboot.demo.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by hy on 2019/9/4 14:02
 * @author hy
 */
@Data
public class SysUserDTO implements Serializable {

    private Integer uid;
    private String username;
    private String password;
    private Integer status;
    private String jwtToken;

}

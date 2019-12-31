package com.hy.learn.springboot.demo.service.impl;

import com.wolwo.hospital.component.exception.CustomException;
import com.wolwo.hospital.dao.UserDao;
import com.wolwo.hospital.mbg.mapper.UserMapper;
import com.wolwo.hospital.mbg.model.User;
import com.wolwo.hospital.mbg.model.UserExample;
import com.wolwo.hospital.pojo.SysUserDTO;
import com.wolwo.hospital.pojo.UserTokenDto;
import com.wolwo.hospital.service.UserService;
import com.wolwo.hospital.util.CustomJwtUtil;
import com.wolwo.hospital.util.JwtUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Created by hy
 * @date on 2019/12/19 16:58
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;
    @Resource
    UserMapper userMapper;

    @Override
    public SysUserDTO getUser(String name, String password) {
        return userDao.getUser(name,password);
    }

    @Override
    public SysUserDTO getUser(Integer uid) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(uid);
        List<User> users = userMapper.selectByExample(userExample);
        SysUserDTO sysUserDTO = new SysUserDTO();
        BeanUtils.copyProperties(users.get(0), sysUserDTO);
        return sysUserDTO;
    }

    @Override
    public UserTokenDto login(String username, String password) {
        SysUserDTO userDTO = userDao.getUser(username, password);
        if (userDTO == null){
            throw new CustomException("账号密码错误");
        }
        String currentTimeMillis = String.valueOf(System.currentTimeMillis());
        //生成jwt token
        String token = JwtUtil.createToken(userDTO.getUid(),currentTimeMillis);
        //将账户和创建时间存进redis
        return new UserTokenDto(token,JwtUtil.getExpiration());
    }

    @Override
    public void logout() {
        String userId = CustomJwtUtil.getUserId();

    }
}

package com.osir.userservice.service.impl;

import com.osir.takeoutpojo.entity.User;
import com.osir.userservice.mapper.UserMapper;
import com.osir.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    @Override
    public User getByOpenid(String openid) {
        return userMapper.getByOpenid(openid);
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public User getById(Long userId) {
        return userMapper.getById(userId);
    }

    @Override
    public Integer getUserTotal(LocalDateTime time) {
        return userMapper.getUserTotal(time);
    }

    @Override
    public Integer getNewUser(LocalDateTime begin, LocalDateTime end) {
        return userMapper.getNewUser(begin,end);
    }
}

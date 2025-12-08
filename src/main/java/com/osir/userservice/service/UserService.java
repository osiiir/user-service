package com.osir.userservice.service;


import com.osir.takeoutpojo.entity.User;

import java.time.LocalDateTime;

public interface UserService {
    User getByOpenid(String openid);

    void insert(User user);

    User getById(Long userId);

    Integer getUserTotal(LocalDateTime time);

    Integer getNewUser(LocalDateTime begin, LocalDateTime end);
}

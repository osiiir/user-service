package com.osir.userservice.controller;

import com.osir.commonservice.utils.LoginUserContext;
import com.osir.takeoutpojo.entity.User;
import com.osir.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user/user/user") // user微服务下的user模块操作user
public class UserController {

    private final UserService userService;

    /**
     * 根据openid查询用户
     * @param openid
     * @return
     */
    @GetMapping("/getByOpenid")
    public User getByOpenid(@RequestParam("openid") String openid){
        return userService.getByOpenid(openid);
    }

    /**
     * 插入用户
     * @param user
     */
    @PostMapping("/insert")
    public void insert(@RequestBody User user){
        userService.insert(user);
    }

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @GetMapping("/getById")
    public User getById(@RequestParam("userId") Long userId){
        return userService.getById(userId);
    }

    /**
     * 根据注册时间统计用户总数
     * @return
     */
    @GetMapping("/getUserTotal")
    Integer getUserTotal(@RequestParam("time") LocalDateTime time){
        return userService.getUserTotal(time);
    }

    /**
     * 统计新增用户
     * @param begin
     * @param end
     * @return
     */
    @GetMapping("/getNewUser")
    Integer getNewUser(@RequestParam("begin") LocalDateTime begin,
                       @RequestParam("end") LocalDateTime end){
        return userService.getNewUser(begin,end);
    }

}

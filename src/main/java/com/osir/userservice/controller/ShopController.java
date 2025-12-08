package com.osir.userservice.controller;

import com.osir.takeoutpojo.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("userShopController")
@RequestMapping("/user/user/shop")
public class ShopController {

    public static final String KEY = "SHOP_STATUS";

    private RedisTemplate redisTemplate;

    ShopController(@Qualifier("redisTemplate") RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    /**
     * 获取店铺营业状态
     * @return
     */
    @GetMapping("/status")
    public Result getStatus(){
        Integer status = (Integer) redisTemplate.opsForValue().get(KEY);
        log.info("获取店铺营业状态:{}",status==1?"营业中":"打烊中");
        return Result.success(status);
    }

}

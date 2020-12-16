package com.bsm.controller;

import com.bsm.TravelApplication;
import com.bsm.dao.TPlaceMapper;
import com.bsm.dao.TProvinceMapper;
import com.bsm.entity.TProvince;
import com.bsm.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.StringReader;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TravelApplication.class)
public class ProvinceControllerTest {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    TProvinceMapper tProvinceMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisUtil redisUtil;

    @org.junit.Test
    public void updateProvince() {

        List<TProvince> tProvinces = tProvinceMapper.selectByExample(null);
        redisTemplate.opsForValue().set("ff", tProvinces);
        Object aa1 = redisTemplate.opsForValue().get("ff");
        List<TProvince> list = (List<TProvince>) aa1;
        System.out.println(list.get(0).getName());

    }

    @Test
    public void testDel()
    {

        redisUtil.set("bb", "123");
        System.out.println(redisUtil.get("bb"));

        List<TProvince> tProvinces = tProvinceMapper.selectByExample(null);
        redisUtil.set("kk", tProvinces);
        Object aa1 = redisUtil.get("kk");
        List<TProvince> list = (List<TProvince>) aa1;
        System.out.println(list.get(0).getName());
        redisUtil.del("bb", "kk","aa");
    }

    @org.junit.Test
    public void postupdateProvince() {
    }
}
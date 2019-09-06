package com.ywyt.springboot3.service;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiejin
 * @date 2019/4/27 17:02
 */
@Service
public class RedisService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void setString(String key, String value) {
        ValueOperations<String,String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set(key,value);
    }


    public String getString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }


    public void setHash(String key, String filedKey, String value) {
        HashOperations<String, Object, Object> hashOperations = stringRedisTemplate.opsForHash();
        hashOperations.put(key,filedKey,value);
    }

    public String getHash(String key, String filedKey) {
        return (String) stringRedisTemplate.opsForHash().get(key, filedKey);
    }

    public long setList(String key, String value) {
        ListOperations<String,String> listOperations = stringRedisTemplate.opsForList();
        return listOperations.leftPush(key, value);
    }

    public List<String> getList(String key, long start, long end) {
        return stringRedisTemplate.opsForList().range(key, start, end);
    }

}

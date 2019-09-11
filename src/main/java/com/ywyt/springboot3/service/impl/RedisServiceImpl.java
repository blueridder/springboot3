package com.ywyt.springboot3.service.impl;

import com.ywyt.springboot3.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiejin
 * @date 2019/9/9 14:32
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private StringRedisTemplate strRedisTpl;


    public void setString(String key, String value) {
        ValueOperations<String,String> valueOperations = strRedisTpl.opsForValue();
        valueOperations.set(key,value);
    }


    public String getString(String key) {
        return strRedisTpl.opsForValue().get(key);
    }


    public void setHash(String key, String filedKey, String value) {
        HashOperations<String, Object, Object> hashOperations = strRedisTpl.opsForHash();
        hashOperations.put(key,filedKey,value);
    }

    public String getHash(String key, String filedKey) {
        return (String) strRedisTpl.opsForHash().get(key, filedKey);
    }

    public long setList(String key, String value) {
        ListOperations<String,String> listOperations = strRedisTpl.opsForList();
        return listOperations.leftPush(key, value);
    }

    public List<String> getList(String key, long start, long end) {
        return strRedisTpl.opsForList().range(key, start, end);
    }
}

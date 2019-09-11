package com.ywyt.springboot3.service;

import java.util.List;

/**
 * @author xiejin
 * @date 2019/4/27 17:02
 */
public interface RedisService {

    void setString(String key, String value);

    String getString(String key);

    void setHash(String key, String filedKey, String value);

    String getHash(String key, String filedKey);

    long setList(String key, String value);

    List<String> getList(String key, long start, long end);

}

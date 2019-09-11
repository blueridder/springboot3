package com.ywyt.springboot3.service.impl;

import com.ywyt.springboot3.entity.TestUser;
import com.ywyt.springboot3.mapper.TestUserMapper;
import com.ywyt.springboot3.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiejin
 * @date 2019/9/8 12:39
 */
@Service
public class TestUserServiceImpl implements TestUserService {

    @Autowired
    private TestUserMapper testUserDao;

    @Override
    public int add(TestUser user) {
        return testUserDao.insert(user);
    }

}

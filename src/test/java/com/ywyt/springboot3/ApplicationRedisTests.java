package com.ywyt.springboot3;

import com.alibaba.fastjson.JSON;
import com.ywyt.springboot3.entity.Emp;
import com.ywyt.springboot3.entity.User;
import com.ywyt.springboot3.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiejin
 * @date 2019/4/27 17:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationRedisTests {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationRedisTests.class);

    @Resource
    private RedisService redisService;

    @Test
    public void contextLoads() {
        redisService.setString("test", "redis测试程序");
        logger.info("我的微信号为：{}",redisService.getString("test"));
    }

    @Test
    public void testRedisHash() {
        // 如果是个实体，我们可以使用json工具转成json字符串，
        User user = new User();
        user.setUserName("csdn");
        user.setAge(123);

        redisService.setHash("user","username", user.getUserName());
        redisService.setHash("user","age",user.getAge().toString());
        logger.info("用户信息：{}", redisService.getHash("user","username"));
    }

    @Test
    public void testRedisList() {
        redisService.setList("list", "football");
        redisService.setList("list", "basketball");
        List<String> list = redisService.getList("list", 0, -1);
        list.forEach(t->{
            logger.info("List中有:{}",t);
        });
    }

    @Test
    public void testJson2Entity() {
        String json = "{\"age\":28,\"birthday\":456681600000,\"boss\":true," +
                "\"forte\":{\"name\":\"java\",\"time\":8},\"forteList\":[{\"name\":\"python\",\"time\":3}," +
                "{\"name\":\"C++\",\"time\":4}],\"lastName\":\"张三\"," +
                "\"list\":[\"java\",\"python\",\"C++\"]," +
                "\"map\":{\"key1\":\"value1\",\"key2\":\"value2\"},\"salary\":20000}";
        Emp emp = JSON.parseObject(json, Emp.class);
        System.out.println(emp);
    }

}

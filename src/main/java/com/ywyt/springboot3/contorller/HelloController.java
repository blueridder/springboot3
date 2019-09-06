package com.ywyt.springboot3.contorller;

import com.alibaba.druid.pool.DruidDataSource;
import com.ywyt.springboot3.conf.DruidConfig;
import com.ywyt.springboot3.entity.Emp;
import com.ywyt.springboot3.entity.User;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author xiejin
 * @date 2019/4/22 14:01
 */
@RestController
@Api(value = "API-HelloController",description = "欢迎页")
@RequestMapping(value="/start")
public class HelloController {

    //使用的是yml
    @Value("${spring.datasource.url}")
    public String name;
    @Autowired
    public Emp emp;

    @RequestMapping(value = "/index")
    @ResponseBody
    public ResponseEntity<String> hello() {
        String as = name;
        System.out.println(as);
        return new ResponseEntity<String>(as, HttpStatus.OK);
    }

    @RequestMapping(value = "getUser")
    public ResponseEntity<User> getUser() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) ac.getBean("user");
        user.setCreatetime(new Date());

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "getEmp")
    public ResponseEntity<Emp> getEmp() {
        return new ResponseEntity<Emp>(emp, HttpStatus.OK);
    }

}

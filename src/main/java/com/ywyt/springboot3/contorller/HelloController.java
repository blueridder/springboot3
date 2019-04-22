package com.ywyt.springboot3.contorller;

import com.ywyt.springboot3.entity.User;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

/**
 * @author xiejin
 * @date 2019/4/22 14:01
 */
@RestController
@RequestMapping(value="/start")
public class HelloController {

    @RequestMapping(value = "/index")
    public ResponseEntity<String> hello() {
        String as = "hello";
        return new ResponseEntity<String>(as, HttpStatus.OK);
    }

    @RequestMapping(value = "getUser")
    public ResponseEntity<User> getUser() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) ac.getBean("user");
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}

package com.ywyt.springboot3.contorller;

import com.ywyt.springboot3.entity.TestUser;
import com.ywyt.springboot3.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiejin
 * @date 2019/9/8 12:43
 */
@RestController
@RequestMapping(value = "testuser")
public class TestUserController {

    @Autowired
    private TestUserService userService;

    @GetMapping(value = "adduser")
    public ResponseEntity<TestUser> addUser() {
        TestUser user = new TestUser();
        user.setName("张三");
        user.setRoleid("2,3");
        userService.add(user);
        return new ResponseEntity<TestUser>(user, HttpStatus.OK);
    }


}

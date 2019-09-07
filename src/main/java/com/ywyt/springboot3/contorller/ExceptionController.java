package com.ywyt.springboot3.contorller;

import com.ywyt.springboot3.exception.LoginException;
import com.ywyt.springboot3.exception.MyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xiejin
 * @date 2019/9/7 11:39
 */
@RestController
@RequestMapping(value = "error")
public class ExceptionController {

    @GetMapping(value = "testExcetion")
    public ResponseEntity<Integer> testException() {
        int result = 1/0;
        return new ResponseEntity<Integer>(result, HttpStatus.OK);

    }

    @GetMapping(value = "myExt")
    public Object myException() {
        throw new MyException("501", "myException异常");
    }

    @RequestMapping(value ="login")
    public Object loginExcption(HttpServletRequest request) {

        String username = request.getParameter("username");
        throw new LoginException(username,"5xx","登录异常：账号或密码异常-->");
    }
}

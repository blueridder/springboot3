package com.ywyt.springboot3.contorller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiejin
 * @date 2019/9/7 15:19
 */
@RestController
@RequestMapping(value="access")
public class LoginController {

    @GetMapping(value = "login")
    public Map<String, Object> login(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        String username = request.getParameter("username");
        resultMap.put("code", HttpStatus.OK);
        resultMap.put("msg", "欢迎" + username + "登录");
        return resultMap;
    }

}

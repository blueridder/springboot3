package com.ywyt.springboot3.contorller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ywyt.springboot3.entity.Emp;
import com.ywyt.springboot3.service.RedisService;
import com.ywyt.springboot3.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

/**
 * @author xiejin
 * @date 2019/9/9 14:41
 */
@RestController
@RequestMapping(value = "redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private Emp emp;

    //这里名称必须是redisTemplate否则就报错：找不到RedisTemplate bean
    //如果要起别名，则需要
    // 1.@Autowried方式:根据类型自动装配
    // 例如：RedisTemplate<Object,Object>就不能写成RedisTemplate<String,Object>
    // 用@Autowired注释，变量名可自定义
    // 2.@Resource方式：默认按照byName注入
    //      @Resource(name = "redisTemplate",type = RedisTemplate.class)
    // 或者 @Resource(name = "redisTemplate")
    // 或者 @Resource(type = RedisTemplate.class)
    // 这时候变量名称可自定义，类型也可以RedisTemplate<String,Object>
    // 如果不设置name或者type，那么变量名称则必须为redisTemplate
    @Autowired
    private RedisTemplate<Object,Object> template;

    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping(value = "addData")
    public JsonResult addStringData() {
        JsonResult result = new JsonResult();

        String key = "name";
        String value = "张三李四";
        redisService.setString(key, value);

        result.setStatus(HttpStatus.OK.toString());
        result.setResult("操作成功");
        return result;
    }

    @RequestMapping(value = "getData")
    public ResponseEntity<Object> getStringData(String key) {
        Object result = redisService.getString(key);
        return new ResponseEntity<Object>(result,HttpStatus.OK);
    }

    @RequestMapping(value = "addModel")
    public JsonResult addModelData() throws JsonProcessingException {
        template.opsForValue().set("成员:emp:10011", emp);
//        String empStr = objectMapper.writeValueAsString(emp);
//        redisService.setString("成员:emp:10011",empStr);
        JsonResult result = new JsonResult();
        result.setStatus(HttpStatus.OK.toString());
        result.setResult("操作成功");
        return result;
    }

    @GetMapping(value = "getModel")
    public ResponseEntity<Emp> getModelData(String key) {
        /*String result = redisService.getString(key);
        Emp emp = JSON.parseObject(result, Emp.class);
        return new ResponseEntity<Emp>(emp, HttpStatus.OK);*/
        Emp entity = (Emp) template.opsForValue().get(key);
        return new ResponseEntity<Emp>(entity, HttpStatus.OK);
    }

    @GetMapping(value = "writeValue")
    public JsonResult addModel() {
        JsonResult result = new JsonResult();
        try {
            objectMapper.writeValue(new File("E:/test.txt"),emp);
            result.setStatus(HttpStatus.OK.toString());
            result.setResult("操作成功");
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

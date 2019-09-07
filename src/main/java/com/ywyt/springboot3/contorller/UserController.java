package com.ywyt.springboot3.contorller;

import com.ywyt.springboot3.utils.JsonResult;
import com.ywyt.springboot3.entity.User;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author xiejin
 * @date 2019/4/23 14:30
 */
@Api(value = "API-userController", description = "用户接口详情")
@RestController
@RequestMapping(value = "api")
public class UserController {

    @Value("${url.orderUrl}")
    private String orderUrl;
    // 创建线程安全的Map
    static Map<Integer, User> users = Collections.synchronizedMap(new HashMap<Integer, User>());

    //Swagger注解
    /*@Api：修饰整个类，描述Controller的作用
    @ApiOperation：描述一个类的一个方法，或者说一个接口
    @ApiParam：单个参数描述
    @ApiModel：用对象来接收参数
    @ApiProperty：用对象接收参数时，描述对象的一个字段
    @ApiResponse：HTTP响应其中1个描述
    @ApiResponses：HTTP响应整体描述
    @ApiIgnore：使用该注解忽略这个API
    @ApiError ：发生错误返回的信息
    @ApiImplicitParam：一个请求参数
    @ApiImplicitParams：多个请求参数*/

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getUserById(@PathVariable(value = "id") Integer id) {

        JsonResult r = new JsonResult();
        try {
            User user = users.get(id);
            r.setResult(user);
            r.setStatus(HttpStatus.OK.toString());
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus(HttpStatus.BAD_REQUEST.toString());
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    /**
     * 查询用户列表
     *
     * @return
     */
    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getUserList() {
        JsonResult r = new JsonResult();
        try {
            List<User> userList = new ArrayList<>(users.values());
            r.setResult(userList);
            r.setStatus(HttpStatus.OK.toString());
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("ERROR");
            e.printStackTrace();
        }

        return ResponseEntity.ok(r);
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "创建用户", notes = "根据user对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add(@RequestBody User user) {
        JsonResult r = new JsonResult();
        try {
            users.put(user.getUserId(), user);
            r.setResult(user.getUserId());
            r.setStatus(HttpStatus.OK.toString());
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("ERROR");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除用户", notes = "根据url的id来删除指定用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete(@PathVariable(value = "id") Integer id) {

        JsonResult r = new JsonResult();
        try {
            users.remove(id);
            r.setResult(id);
            r.setStatus(HttpStatus.OK.toString());
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("ERROR");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    /**
     * 根据id修改用户信息
     *
     * @param id
     * @param user
     * @return
     */
    @ApiOperation(value = "更新信息", notes = "根据url的id来更新指定用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "User", value = "用户实体User", required = true, dataType = "User")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful-请求已完成"),
            @ApiResponse(code = 400, message = "检查参数或类型是否一致"),
            @ApiResponse(code = 404, message = "服务器找不到指定的资源")
    })
    @RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update(@PathVariable(value = "id") Integer id, @RequestBody User user) {
        JsonResult r = new JsonResult();
        try {
            User u = users.get(id);
            u.setUserName(user.getUserName());
            u.setAge(user.getAge());
            users.put(id, u);
            r.setStatus(HttpStatus.OK.toString());
            r.setResult(u);
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("Error");
            e.printStackTrace();
        }

        return ResponseEntity.ok(r);
    }



//    @ApiIgnore//使用该注解忽略这个api
    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String jsonTest() {
        return orderUrl;
    }


}
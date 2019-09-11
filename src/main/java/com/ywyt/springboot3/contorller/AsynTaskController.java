package com.ywyt.springboot3.contorller;

import com.ywyt.springboot3.task.AsynTask;
import com.ywyt.springboot3.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @author xiejin
 * @date 2019/9/10 14:46
 */
@RestController
@RequestMapping(value = "async")
public class AsynTaskController {

    @Autowired
    private AsynTask asynTask;

    @GetMapping(value = "excSync")
    public JsonResult excSync() throws InterruptedException {
        JsonResult jsonResult = new JsonResult();
        long begin = System.currentTimeMillis();
        asynTask.asynTask1();
        asynTask.asynTask2();
        asynTask.asynTask3();
        asynTask.asynTask4();
        long end = System.currentTimeMillis();
        long total = end-begin;
        System.out.println("同步任务耗时：" + total);
        jsonResult.setStatus(HttpStatus.OK.toString());
        jsonResult.setResult(end - begin);
        return jsonResult;
    }

    @GetMapping(value = "excAsync")
    public JsonResult excAsync() throws InterruptedException {
        JsonResult jsonResult = new JsonResult();
        long begin = System.currentTimeMillis();
        Future<String> task5 = asynTask.asynTask5();
        Future<String> task6 = asynTask.asynTask6();
        Future<String> task7 = asynTask.asynTask7();
        for(;;) {
            if (task5.isDone() && task6.isDone() && task7.isDone()) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        long total = end-begin;
        System.out.println("异步任务总耗时：" + total);
        jsonResult.setStatus(HttpStatus.OK.toString());
        jsonResult.setResult(end - begin);
        return jsonResult;
    }




}

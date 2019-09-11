package com.ywyt.springboot3.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * 异步任务业务类
 * @author xiejin
 * @date 2019/9/10 14:41
 */
@Component
//@Async 表明该类和类中的所有方法都是异步执行的：按照执行时间最长的任务算作总用时
// 如果去掉，则表示是同步执行：按照所有方法执行总用时算作总用时
@Async
public class AsynTask {


//    @Async
    public void asynTask1() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(1000L);
        long end = System.currentTimeMillis();
        System.out.println("异步任务1耗时："+(end-begin));
    }

//    @Async
    public void asynTask2() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(2000L);
        long end = System.currentTimeMillis();
        System.out.println("异步任务2耗时："+(end-begin));
    }

//    @Async
    public void asynTask3() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(3000L);
        long end = System.currentTimeMillis();
        System.out.println("异步任务3耗时："+(end-begin));
    }

//    @Async
    public void asynTask4() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(4000L);
        long end = System.currentTimeMillis();
        System.out.println("异步任务4耗时："+(end-begin));
    }

    public Future<String> asynTask5() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(4000L);
        long end = System.currentTimeMillis();
        System.out.println("异步任务5耗时："+(end-begin));
        return new AsyncResult<>("异步任务5");
    }

    public Future<String> asynTask6() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(1000L);
        long end = System.currentTimeMillis();
        System.out.println("异步任务6耗时："+(end-begin));
        return new AsyncResult<>("异步任务6");
    }

    public Future<String> asynTask7() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(3000L);
        long end = System.currentTimeMillis();
        System.out.println("异步任务7耗时："+(end-begin));
        return new AsyncResult<>("异步任务7");
    }
}

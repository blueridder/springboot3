package com.ywyt.springboot3.thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author xiejin
 * @date 2019/9/11 16:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CallableFuture {
    @Test
    public void testFutureAndCallable() {
        MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<String>(myCallable);
        String res = null;
        try {
            new Thread(futureTask, "futureTask--").start();
            res = futureTask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(res);
    }
    class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("I am implements Callable");
            return "Success";
        }
    }
}


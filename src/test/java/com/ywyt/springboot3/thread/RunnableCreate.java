package com.ywyt.springboot3.thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author xiejin
 * @date 2019/9/11 15:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RunnableCreate {

    @Test
    public void testCreateThread() {
        new Thread(new MyThread(), "实现Runnable").start();
        new Thread(()-> {
            System.out.println(Thread.currentThread().getName());
        }).start();
        Runnable run=()->{
            System.out.println(Thread.currentThread().getName());
        };

    }


    public class MyThread implements Runnable {
        @Override
        public void run() {

        }
    }
}

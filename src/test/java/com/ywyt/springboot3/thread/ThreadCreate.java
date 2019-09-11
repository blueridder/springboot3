package com.ywyt.springboot3.thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author xiejin
 * @date 2019/9/11 16:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ThreadCreate {
    @Test
    public void testCreateThread() {
        new MyThread().start();
        new MyThread(()-> System.out.println(MyThread.currentThread().getName()),"MyThread--").start();
        new Thread(new MyThread(),"MyThread--").start();
    }

    class MyThread extends Thread{
        public MyThread() {
        }
        public MyThread(Runnable target, String name) {
            super(target, name);
        }
        @Override
        public void run() {
            super.run();
        }
    }
}

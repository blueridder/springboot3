package com.ywyt.springboot3.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiejin
 * @date 2019/9/10 11:03
 */
@Component
public class Schedule {
    private static final Logger logger = LoggerFactory.getLogger(Schedule.class);
    /**
     * fixedRate 执行频率 5秒一次
     */
    //@Scheduled(fixedRate = 5000)
    public void testDemo() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String nowTime = sf.format(now);
        System.out.println("当前时间："+nowTime);
    }

    @Scheduled(cron ="*/1 * * * * *")
    public void testCorn1() throws InterruptedException {
//        Thread.sleep(5000L);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String nowTime = sf.format(now);
//        System.out.println("当前时间："+nowTime);
        logger.info("当前时间："+nowTime);
    }

    @Scheduled(cron ="*/3 * * * * *")
    public void testCorn2() throws InterruptedException {
//        Thread.sleep(5000L);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String nowTime = sf.format(now);
//        System.out.println("当前时间："+nowTime);
        logger.info("当前时间："+nowTime);
    }

    @Scheduled(cron ="*/3 * * * * *")
    public void testCorn3() throws InterruptedException {
//        Thread.sleep(5000L);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String nowTime = sf.format(now);
//        System.out.println("当前时间："+nowTime);
        logger.info("当前时间："+nowTime);
    }

    @Scheduled(cron ="*/4 * * * * *")
    public void testCorn4() throws InterruptedException {
//        Thread.sleep(5000L);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String nowTime = sf.format(now);
//        System.out.println("当前时间："+nowTime);
        logger.info("当前时间："+nowTime);
    }



}

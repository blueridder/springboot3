package com.ywyt.springboot3.conf;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author xiejin
 * @date 2019/9/11 9:24
 */
//@Configuration
public class ExecutorPoolConfiguration {

    //@Bean
    public ThreadPoolTaskExecutor defaultThreadPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程数
        executor.setCorePoolSize(16);
        //指定最大线程数
        executor.setMaxPoolSize(64);
        //队列中最大的数据
        executor.setQueueCapacity(16);
        //线程名称前缀
        executor.setThreadNamePrefix("defaultPool_");
        //rejection-policy:当pool已经达到max size的时候，如何处理新任务
        //CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行对拒绝task的处理策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //线程空闲后的最大存活时间
        executor.setKeepAliveSeconds(60);
        //加载
        executor.initialize();
        return executor;
    }
}

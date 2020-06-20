package com.example.study.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 本应用的线程管理器，1：首先要做一个池子 2：必须做成单例模式(懒汉)，防止创建多个线程，达不到管理效果
 * 3：考虑线程安全问题
 * Created by acer-pc on 2018/6/19.
 */

/**
 * 一个简易的线程池管理类，提供三个线程池
 */
public class ThreadManager {

    private static ThreadPool mThreadPool;

    public static ThreadPool getThreadPool() {
        if (mThreadPool == null) {
            synchronized (ThreadManager.class) {
                if (mThreadPool == null) {

                    int cpuCount = Runtime.getRuntime().availableProcessors(); // 获取cpu数量，即核数
                    int corePoolSize = Math.max(2, Math.min(cpuCount - 1, 4));//核心池数量被限定在2到4之间。
                    int maximumPoolSize = cpuCount * 2 + 1;

                    mThreadPool = new ThreadPool(corePoolSize, maximumPoolSize, 1L);
                }
            }
        }
        return mThreadPool;

    }

    // 线程池---对系统的线程池做的封装
    public static class ThreadPool {
        private int corePoolSize;
        private int maximumPoolSize;
        private long keepAliveTime;

        private ThreadPoolExecutor executor; // 执行体-->系统底层自带的线程池

        public ThreadPool(int corePoolSize, int maximumPoolSize,
                          long keepAliveTime) {
            super();
            this.corePoolSize = corePoolSize;
            this.maximumPoolSize = maximumPoolSize;
            this.keepAliveTime = keepAliveTime;
        }


        //1.执行任务
        public void execute(Runnable r) {

            if (executor == null) {
                executor = new ThreadPoolExecutor(corePoolSize,
                        maximumPoolSize, keepAliveTime, TimeUnit.SECONDS,
                        new LinkedBlockingDeque<Runnable>(),
                        Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.AbortPolicy());
                // 参数1:corePoolSize核心线程数；参数2：maximumPoolSize最大线程数；参数3：keepAliveTime休息时间；参数4：unit时间单位；参数5：workQueue线程队列；参数6：threadFactory线程工厂；参数7：handler异常处理策略
            }

            //线程池执行一个runnable对象,具体运行时机线程池executor底层说了算
            executor.execute(r);
        }

        //2.取消任务
        public void cancel(Runnable r) {
            if (executor != null) {
                //从线程未开始的排队队列中移除对象
                executor.getQueue().remove(r);
            }
        }
    }
}

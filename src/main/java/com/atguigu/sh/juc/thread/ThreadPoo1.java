package com.atguigu.sh.juc.thread;

import java.util.concurrent.*;

/**
 * @program: juc
 * @description
 * @author: xiangyuyi
 * @create: 2021-04-15 11:20
 **/
public class ThreadPoo1 {

    public static void main(String[] args) {
        Executor executor = Executors.newSingleThreadExecutor();
        Executor executor1 = Executors.newFixedThreadPool(1);
        Executor executor2 = Executors.newCachedThreadPool();

        //cpu核数，一般可以设置最大线程为核数+1
        Runtime.getRuntime().availableProcessors();
        Executor executor4 =  new ThreadPoolExecutor(2, 5,
                        2L, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(3),Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
    }
}

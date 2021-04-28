package com.atguigu.sh.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @program: juc
 * @description
 * @author: xiangyuyi
 * @create: 2021-04-14 18:15
 * 线程顺序执行
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for(int i = 0; i< 10 ;i ++ ){
            new Thread(() -> {
                System.out.println("离开" + Thread.currentThread().getName());
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("关门");
    }
}

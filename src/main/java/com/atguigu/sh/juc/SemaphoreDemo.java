package com.atguigu.sh.juc;

import java.util.concurrent.Semaphore;

/**
 * @program: juc
 * @description
 * @author: xiangyuyi
 * @create: 2021-04-14 18:40
 **/
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i =0; i< 6; i++){
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到了车位");
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + "离开了");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}

package com.atguigu.sh.juc.thread;

import java.util.concurrent.CompletableFuture;

/**
 * @program: juc
 * @description
 * @author: xiangyuyi
 * @create: 2021-04-15 17:58
 **/
public class CompleteFurtureDemo {
    public static void main(String[] args) throws Exception{
        CompletableFuture<Void> voidCompletableFuture =  CompletableFuture.runAsync(() ->{
            System.out.println("没有返回值" + Thread.currentThread().getName());
        });
        voidCompletableFuture.get();

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() ->{
            System.out.println("返回值" + Thread.currentThread().getName());
            int a = 10/0;
            return 1024;
        });
        System.out.println(completableFuture.whenCompleteAsync((x,y) ->{
            System.out.println("x:" + x);
            System.out.println("y:" + y);
        }).exceptionally(f -> {
            System.out.println("f:" + f);
            return 4444;
        }).get());
    }
}

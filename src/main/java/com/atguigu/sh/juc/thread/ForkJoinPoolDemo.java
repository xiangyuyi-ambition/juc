package com.atguigu.sh.juc.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @program: juc
 * @description
 * @author: xiangyuyi
 * @create: 2021-04-15 16:53
 **/
public class ForkJoinPoolDemo {
    public static void main(String[] args) throws Exception {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(new Count(0,1000));
        System.out.println(forkJoinTask.get());
        }
    }

class Count extends RecursiveTask<Integer> {

    private static final Integer ADJUE = 100;

    public Count(int begin, int end){
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if(end - begin <= ADJUE){
            for(int i = begin;i<= end ;i++){
                result = result + i;
            }
        }else {
            int middle = (end + begin) /2;
            Count count = new Count(begin,middle);
            Count count1 = new Count(middle +1 ,end);
            count.fork();
            count1.fork();
            result = count.join() + count1.join();
        }
        return result;
    }
    private int begin;

    private int end;

    private int result = 0;

}

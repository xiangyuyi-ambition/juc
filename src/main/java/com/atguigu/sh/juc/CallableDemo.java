package com.atguigu.sh.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @program: juc
 * @description
 * @author: xiangyuyi
 * @create: 2021-04-14 17:14
 *
 * 1.callable的get方法一般放在最后
 **/
public class CallableDemo {
    public static void main(String[] args) throws Exception{
        MyThread myThread = new MyThread();
        FutureTask futureTask = new FutureTask(myThread);
        new Thread(futureTask, "A").start();
        System.out.println(futureTask.get());
    }
}

class MyThread implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        return 1024;
    }
}

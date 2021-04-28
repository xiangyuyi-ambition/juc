package com.atguigu.sh.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: juc
 * @description
 * @author: xiangyuyi
 * @create: 2021-04-13 14:36
 **/
public class Ticket {
    private int number = 30;
    private Lock lock = new ReentrantLock();

    public void saleticker(){
        lock.lock();
        try{
            if(number > 0){
                number --;
                System.out.println(Thread.currentThread().getName() +" nubmer:" + number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }
}

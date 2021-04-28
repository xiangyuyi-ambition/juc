package com.atguigu.sh.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: juc
 * @description
 * @author: xiangyuyi
 * @create: 2021-04-13 19:31
 **/
public class Aircondition {
    private int number =  0;

    private Lock reentrantLock = new ReentrantLock();
    private Condition condition = reentrantLock.newCondition();

    public  void add() throws InterruptedException{
        reentrantLock.lock();
        try{
            while (number != 0){
                //this.wait();
                condition.await();
            }
            number ++ ;
            System.out.println(Thread.currentThread().getName() + ":" + number);
            //this.notifyAll();
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }

    }

    public  void delete() throws InterruptedException {
        reentrantLock.lock();
        try {
            while (number == 0){
                //this.wait();
                condition.await();
            }
            number -- ;
            System.out.println(Thread.currentThread().getName() + ":" + number);
            //this.notifyAll();
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }

    }


}

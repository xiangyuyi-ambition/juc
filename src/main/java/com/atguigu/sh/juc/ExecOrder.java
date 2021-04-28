package com.atguigu.sh.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: juc
 * @description
 * @author: xiangyuyi
 * @create: 2021-04-14 10:51
 * 三个线程顺序执行，A ->B ->C
 * AA打印五次，BB打印10次，CC打印15次
 * 循环执行10次
 **/
public class ExecOrder {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(() ->{
            for(int i=0; i<10; i++){
                shareResource.print5();
            }
        },"AA").start();

        new Thread(() ->{
            for(int i=0; i<10; i++){
                shareResource.print10();
            }
        },"BB").start();

        new Thread(() ->{
            for(int i=0; i<10; i++){
                shareResource.print15();
            }
        },"CC").start();
    }
}


class ShareResource{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void print5(){
        lock.lock();
        try{
            while (number != 1){
                condition.await();
            }
            for(int i = 0; i< 5;i++){
                System.out.println(Thread.currentThread().getName() + i);
            }
            number = 2;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print10(){
        lock.lock();
        try{
            while (number != 2){
                condition2.await();
            }
            for(int i = 0; i< 10;i++){
                System.out.println(Thread.currentThread().getName() + i);
            }
            number = 3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try{
            while (number != 3){
                condition3.await();
            }
            for(int i = 0; i< 15;i++){
                System.out.println(Thread.currentThread().getName() + i);
            }
            number = 1;
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}

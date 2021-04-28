package com.atguigu.sh.juc;

/**
 * @program: juc
 * @description
 * @author: xiangyuyi
 * @create: 2021-04-13 19:32
 * 两个线程，操作初始值为0的一个变量，实现一个线程对该变量加一
 * 另一个线程对该变量减一，交替实现，共10轮
 * 1.在高内聚低耦合的前提下：线程操作资源类
 * 2.判断--干活---通知
 * 3.多线程内部判断不使用if，使用while（带有循环检查）
 **/
public class ThreadWaitNotify {

    public static void main(String[] args) throws InterruptedException {
        Aircondition aircondition = new Aircondition();

        new Thread(() -> {
            for(int i=0; i<10; i++){
                try {
                    aircondition.add();
                }catch (Exception e){
                }
            }
        }, "A").start();


        new Thread(() -> {
            for(int i=0; i<10; i++){
                try {
                    aircondition.add();
                }catch (Exception e){
                }
            }
        }, "B").start();


        new Thread(() -> {
            for(int i=0; i<10; i++){
                try {
                    aircondition.delete();
                }catch (Exception e){
                }
            }
        }, "C").start();


        new Thread(() -> {
            for(int i=0; i<10; i++){
                try {
                    aircondition.delete();
                }catch (Exception e){
                }
            }
        }, "D").start();
    }
}

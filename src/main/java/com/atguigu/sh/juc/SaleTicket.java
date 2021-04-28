package com.atguigu.sh.juc;

/**
 * @program: juc
 * @description
 * @author: xiangyuyi
 * @create: 2021-04-13 13:53
 * 多线程编程思想：在高内聚低耦合的前提下：线程操作资源类
 **/
public class SaleTicket {

    public static void main(String[] args) {
       final Ticket ticket =  new Ticket();
       new Thread(() -> {for(int i=0; i< 40; i++){ticket.saleticker();}}, "A").start();
       new Thread(() -> {for(int i=0; i< 40; i++){ticket.saleticker();}}, "V").start();
       new Thread(() -> {for(int i=0; i< 40; i++){ticket.saleticker();}}, "VC").start();
    }
}

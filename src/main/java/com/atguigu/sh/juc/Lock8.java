package com.atguigu.sh.juc;

/**
 * @program: juc
 * @description
 * @author: xiangyuyi
 * @create: 2021-04-14 11:18
 **/
public class Lock8 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendEmail();
        },"AA");
        Thread.sleep(100);
        new Thread(() -> {
            phone.sendSMS();
        },"BB");
        phone.hello();

    }
}

class Phone{

    public synchronized void sendEmail(){
        System.out.println("send Email");
    }

    public synchronized void sendSMS(){
        System.out.println("send SMS");
    }

    public  void hello(){
        System.out.println("hello");
    }


}

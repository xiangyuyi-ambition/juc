package com.atguigu.sh.juc;

import java.util.concurrent.CyclicBarrier;

/**
 * @program: juc
 * @description
 * @author: xiangyuyi
 * @create: 2021-04-14 18:26
 **/
public class CyclicBarrierDemo {
    public static void main(String[] args) throws Exception {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> { System.out.println("7课龙珠召唤神龙");});

        for(int i=0; i<7; i++){
            System.out.println("i：" + i);
            new Thread(() -> {
                try{
                    cyclicBarrier.await();
                }catch (Exception e){
                   e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}

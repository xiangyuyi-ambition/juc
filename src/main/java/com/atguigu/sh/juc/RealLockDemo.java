package com.atguigu.sh.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: juc
 * @description
 * @author: xiangyuyi
 * @create: 2021-04-14 19:21
 **/
public class RealLockDemo {
    public static void main(String[] args) {
        Cache cache = new Cache();
        for(int i=0; i<5;i ++ ){
            final  int number = i;
            new Thread(() ->{
                cache.push(String.valueOf(number),String.valueOf(number));
            },"A").start();
        }

        for(int i=0; i<5;i ++ ){
            final  int number = i;
            new Thread(() ->{
                System.out.println( cache.getValue(String.valueOf(number)));
                try {
                    Thread.sleep(300);
                }catch (Exception e){
                    e.printStackTrace();
                }
            },"A").start();
        }

    }
}

class Cache{
    private volatile Map<String,String> stringMap = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void push(String key,String value){
        System.out.println("开始插入数据" + key + ":" + value);
        readWriteLock.writeLock().lock();
        try {
            Thread.sleep(300);
            stringMap.put(key,value);
            System.out.println("插入数据完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }


    }

    public String getValue(String key){
        readWriteLock.readLock().lock();
        try {
            Thread.sleep(300);
            return stringMap.get(key);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            readWriteLock.readLock().unlock();
        }
    }

}

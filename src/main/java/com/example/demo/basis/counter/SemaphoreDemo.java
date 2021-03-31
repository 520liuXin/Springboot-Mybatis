package com.example.demo.basis.counter;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/*
 * @Author liuxin
 * @Description //TODO Semaphore 信号量 demo 抢车位
 **/
public class SemaphoreDemo {


    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);
        //Semaphore semaphore=new Semaphore(6,true);true代表公平锁
        for(int i=1;i<=6;i++){
            new Thread(()->{
                try {
                    semaphore.acquire();//得到
                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                            TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName()+"离开车位");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//释放
                }

            },String.valueOf(i)).start();
        }

/*semaphore.acquire() 获得，假设如果已经满了，等待，等待被释放为止！
 semaphore.release(); 释放，会将当前的信号量释放 + 1，然后唤醒等待的线程！
作用： 多个共享资源互斥的使用！并发限流，控制最大的线程数！

 * */



    }


}

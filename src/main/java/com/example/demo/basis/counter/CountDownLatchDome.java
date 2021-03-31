package com.example.demo.basis.counter;

import java.util.concurrent.CountDownLatch;

/*
 * @Author liuxin
 * @Description //TODO 常用辅助类（必会）
 TODO CountDownLatch：减法计数器
 TODO countDownLatch.countDown(); // 数量-1
 TODO countDownLatch.await(); // 等待计数器归零，然后再向下执行
 TODO 每次有线程调用 countDown() 数量-1，假设计数器变为0，countDownLatch.await() 就会被唤醒，继续
执行！

 **/
public class CountDownLatchDome {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(6);

        for (int i=1;i<=6;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" Go out");
                 countDownLatch.countDown();//数量减1
            },String.valueOf(i)).start();
        }
        System.out.println("=============================");
        countDownLatch.await(); //等待计数器归零，然后再向下执行
        System.out.println("close");


    }

}

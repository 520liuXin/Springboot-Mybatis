package com.example.demo.basis.lock8;

import java.util.concurrent.TimeUnit;

/*
 * @Author liuxin
 * @Description //TODO
 *
 * * 3、 增加了一个普通方法后！先执行发短信还是Hello？ 普通方法
 * 4、 两个对象，两个同步方法， 发短信还是 打电话？ // 打电话
 **/
public class TestLock2 {
    /**
     *
     **/
    public static void main(String[] args) {
        Phone1 phone=new Phone1();
        Phone1 phone1=new Phone1();

        new Thread(()->{
            phone.sendSms();
        },"A").start();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone1.call();
        },"B").start();

        new Thread(()->{
            phone1.hello();
        },"B").start();
    }

}


class Phone1{
    //// synchronized 锁的对象是方法的调用者！、
    //// 两个方法用的是同一个锁，谁先拿到谁执行！
    public synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }


    public synchronized void call(){

        System.out.println("打电话");
    }

    public  void hello(){

        System.out.println("hello word");
    }
}

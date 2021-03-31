package com.example.demo.basis.lock8;

import java.util.concurrent.TimeUnit;

/*
 * @Author liuxin
 * @Description //TODO
 * * 5、增加两个静态的同步方法，只有一个对象，先打印 发短信
 * 6、两个对象！增加两个静态的同步方法， 先打印 发短信

 **/
public class TestLock3 {
    /**
     *
     **/
    public static void main(String[] args) {
        Phone2 phone2=new Phone2();
        Phone2 phone3=new Phone2();

        new Thread(()->{
            phone2.sendSms();
        },"A").start();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone3.call();
        },"B").start();

        new Thread(()->{
            phone2.hello();
        },"B").start();
    }

}


class Phone2{
    // synchronized 锁的对象是方法的调用者！
// static 静态方法
// 类一加载就有了！锁的是Class
    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }


    public  static synchronized void call(){

        System.out.println("打电话");
    }

    public  void hello(){

        System.out.println("hello word");
    }
}

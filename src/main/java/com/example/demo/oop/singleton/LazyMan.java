package com.example.demo.oop.singleton;

/*
 * @Author liuxin
 * @Description //TODO 懒汉式，线程不安全： 基础
 *                 在 getInstance 方法前加 synchronized 关键字，也可以在 getInstance 方法内增
加 synchronized 来实现。最优的办法是如通用代码那样写。
 **/
public class LazyMan {
    private LazyMan(){
        System.out.println(Thread.currentThread().getName()+"ok");

    }
    private volatile static  LazyMan lazyMan;


    public  static synchronized  LazyMan getInstance(){
        if (lazyMan == null){
             lazyMan=new LazyMan();
        }
        return lazyMan;
    }



    //多线程并发
    public static void main(String[] arg){
        for (int i=0;i<10;i++){
            new Thread(()->{
                LazyMan.getInstance();
            }).start();
        }
    }

}

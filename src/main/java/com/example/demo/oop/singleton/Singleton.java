package com.example.demo.oop.singleton;

/*
 * @Author liuxin
 * @Description //TODO 单例模式 通用模式
 **/
public class Singleton {
    private static final Singleton singleton = new Singleton();
    //限制产生多个对象
    private Singleton(){
    }
    //通过该方法获得实例对象
    public static Singleton getSingleton(){
        return singleton;
    }
    //类中其他方法，尽量是 static
    public static void doSomething(){
    }
}

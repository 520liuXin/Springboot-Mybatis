package com.example.demo.basis.reflex;

/*
 * @Author liuxin
 * @Description //TODO 类加载的demo
 **/
public class ReflexDemo1 {
    public static void main(String[] args) {
        ClassDemo classDemo=new ClassDemo();
        System.out.println(ClassDemo.m);
    }


}

class ClassDemo{

    static{
        System.out.println("静态代码块加载");
        m=2000;
    }

    static int m=100;



    public ClassDemo() {
        System.out.println("类的无参构造器加载");
    }
}
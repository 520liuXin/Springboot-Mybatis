package com.example.demo.basis.thread;

/*
 * @Author liuxin
 * @Description //TODO 线程的创建 继承Thread实现多线程 线程不是立即执行，由CPU调度安排
 **/

//1.start（）和run方法的区别
//调用start方法可以启动一个线程，而run方法只是thread类中的一个普通方法调用，还是从主线程里面执行的。
public class ThreadDemo1Thread extends Thread {
    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            System.out.println("liuxin在学习敲代码"+i);

        }

       System.out.println();
    }

     public static void main(String[] args) throws InterruptedException {
        ThreadDemo1Thread threadDemo1=new ThreadDemo1Thread();


       // threadDemo1.run();
         //threadDemo1.start();
        for(int i=0;i<2000;i++){
            System.out.println("wozai敲代码"+i);
            Thread.sleep(1);
        }

    }
}

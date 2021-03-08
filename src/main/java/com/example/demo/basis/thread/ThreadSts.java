package com.example.demo.basis.thread;

/*
 * @Author liuxin
 * @Description //TODO
 **/
public class ThreadSts {

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            System.out.println("线程1启动中");
        });
        Thread thread2=new Thread(()->{
            System.out.println("线程2启动中");
        });
        Thread thread3=new Thread(()->{
            System.out.println("线程3启动中");
        });
        Thread thread4=new Thread(()->{
            System.out.println("线程4启动中");
        });
        Thread.State state= thread.getState();
        System.out.println(state);
        thread.setPriority(10);
        thread4.setPriority(10);
        thread2.setPriority(1);
        thread3.setPriority(5);
        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();


        state= thread.getState();
        System.out.println(state);

        while (state!=Thread.State.TERMINATED){
            Thread.sleep(100);
            state= thread.getState();
            System.out.println(state);
        }

    }
}

package com.example.demo.basis.thread;

/*
 * @Author liuxin
 * @Description //TODO 使用synchronized实现同步方法，锁的是this
 **/
public class ThreadDemo3 implements Runnable {

    private int ticket =100;
    boolean falg=true;
    @Override
    public void run() {
        while (falg){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    //使用synchronized实现同步方法，锁的是this
    private synchronized   void  buy() throws InterruptedException {
        if (ticket<=0){
            falg=false;
            return;
        }
        Thread.sleep(200);
        System.out.println(Thread.currentThread().getName()+"-->抢到了第"+ticket+"张票");
        ticket--;
    }

    public static void main(String[] args) {
        ThreadDemo3 threadDemo3=new ThreadDemo3();
        new Thread(threadDemo3,"刘信1").start();
        new Thread(threadDemo3,"刘信2").start();
        new Thread(threadDemo3,"刘信3").start();
        new Thread(threadDemo3,"刘信5").start();
        new Thread(threadDemo3,"刘信6").start();
        new Thread(threadDemo3,"刘信7").start();
    }
}

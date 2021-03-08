package com.example.demo.basis.thread;

import java.util.concurrent.locks.ReentrantLock;

/*
 * @Author liuxin
 * @Description //TODO
 **/
public class TestLock {

    public static void main(String[] args) {
        Buy buy=new Buy();
        new Thread(buy).start();
        new Thread(buy).start();
        new Thread(buy).start();
        new Thread(buy).start();
        buy.notify();
    }



    static class  Buy implements Runnable{
        private int pig=100;

        final  ReentrantLock lock = new ReentrantLock();
        @Override
        public void run() {
            while (pig>0){
                lock.lock();
                try {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(pig--);
                }finally {
                    lock.unlock();
                }

            }

        }
    }



}

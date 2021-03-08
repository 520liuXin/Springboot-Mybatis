package com.example.demo.basis.thread;

/*
 * @Author liuxin
 * @Description //TODO
 **/
public class ThreadDemo2Runnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("我在敲代码" + i);
        }
    }

    public static void main(String[] args) {
        ThreadDemo2Runnable threadDemo2 = new ThreadDemo2Runnable();
        Thread thread = new Thread(threadDemo2);
        thread.start();
        System.out.println(thread.getName());

    }
}

package com.example.demo.basis.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * @Author liuxin
 * @Description //TODO
 **/
public class ThreadPool {

    public static void main(String[] args)  {
        ExecutorService executorService=Executors.newFixedThreadPool(10);
        executorService.execute(new test());
        executorService.execute(new test());
        executorService.execute(new test());
        executorService.execute(new test());
        executorService.execute(new test());
        executorService.execute(new test());
        executorService.shutdown();

    }


    static class test implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

}

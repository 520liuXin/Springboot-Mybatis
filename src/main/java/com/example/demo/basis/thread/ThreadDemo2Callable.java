package com.example.demo.basis.thread;

import org.apache.catalina.Executor;

import java.util.concurrent.*;

/*
 * @Author liuxin
 * @Description //TODO
 **/
public class ThreadDemo2Callable implements Callable<Boolean> {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadDemo2Callable threadDemo2 = new ThreadDemo2Callable();

        //执行服务
        ExecutorService ser= Executors.newFixedThreadPool(1);
        //提交执行
        Future<Boolean> res=ser.submit(threadDemo2);
        //获取结果
        boolean res1=res.get();
        //关闭服务
        ser.shutdownNow();

    }

    @Override
    public Boolean call() throws Exception {
        for (int i = 0; i < 200; i++) {
            System.out.println("我在敲代码" + i);
        }
        return true;
    }
}

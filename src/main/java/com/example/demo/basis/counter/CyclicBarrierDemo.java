package com.example.demo.basis.counter;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
 * @Author liuxin
 * @Description //TODO 加法计数器 集齐7颗龙珠召唤神龙
 **/
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()->{
           System.out.println("召唤神龙");
        });
        for(int i=1;i<=7;i++){
            int temp=i;
            new Thread(
                    ()->{
                        System.out.println(Thread.currentThread().getName()+"收取了"+temp+"颗龙珠");
                        try {
                            cyclicBarrier.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (BrokenBarrierException e) {
                            e.printStackTrace();
                        }
                    }
            ,String.valueOf(i)).start();

        }


    }




}

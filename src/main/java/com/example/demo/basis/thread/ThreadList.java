package com.example.demo.basis.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * @Author liuxin
 * @Description //TODO
 **/
public class ThreadList {

    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        CopyOnWriteArrayList<String> list1=new CopyOnWriteArrayList<String>();

        
        for(int i=0;i<10000;i++){

                new Thread(()->{
                    synchronized (list){
                        list.add(Thread.currentThread().getName());
                    }
                }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());



        for(int i=0;i<10000;i++){

            new Thread(()->{
                    list1.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list1.size());
    }
}

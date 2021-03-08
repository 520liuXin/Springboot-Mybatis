package com.example.demo.basis.pc;

import javax.xml.crypto.Data;

/*
 * @Author liuxin
 * @Description //TODO 使用synchronized实现生产者和消费者demo，
 **/
public class Pcdemo1 {


    public static void main(String[] args) {
        data data=new data();
        new Thread(()->{
            for(int i=0;i<40;i++){
              data.increment();
            }
        },"A").start();

        new Thread(()->{
            for(int i=0;i<40;i++){
                data.decrement();
            }
        },"B").start();
        new Thread(()->{
            for(int i=0;i<40;i++){
                data.increment();
            }
        },"C").start();

        new Thread(()->{
            for(int i=0;i<40;i++){
                data.decrement();
            }
        },"D").start();


    }

}


///判断等待，业务，通知
class data{
    private int num=0;

    public synchronized void increment()  {
        while (num!=0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"--->"+num);
        this.notifyAll();
    }

    public  synchronized void  decrement()  {
        while(num==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"--->"+num);
        this.notifyAll();
    }
}

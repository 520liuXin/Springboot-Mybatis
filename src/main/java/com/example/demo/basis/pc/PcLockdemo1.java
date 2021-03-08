package com.example.demo.basis.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @Author liuxin
 * @Description //TODO 使用Lock实现生产者和消费者demo，
 **/
public class PcLockdemo1 {


    public static void main(String[] args) {
        data1 data=new data1();
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
class data1{
    private int num=0;
    Lock lock=new ReentrantLock();
    Condition condition= lock.newCondition();

    public  void increment()  {
        lock.lock();
        try {
            while (num!=0){
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"--->"+num);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public  void  decrement()  {
        lock.lock();
        try {
            while(num==0){
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"--->"+num);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

package com.example.demo.basis.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @Author liuxin
 * @Description //TODO 使用Lock实现生产者和消费者demo，实现指定唤醒
 **/
public class PcLockConditiondemo2 {


    public static void main(String[] args) {
        DataLock data=new DataLock();
        new Thread(()->{
            for(int i=0;i<40;i++){
              data.A();
            }
        },"A").start();

        new Thread(()->{
            for(int i=0;i<40;i++){
                data.B();
            }
        },"B").start();
        new Thread(()->{
            for(int i=0;i<40;i++){
                data.C();
            }
        },"C").start();

    }

}


///判断等待，业务，通知
class DataLock{
    private int num=1; //1A  2B 3C
   private   Lock lock=new ReentrantLock();
    private Condition conditionA= lock.newCondition();
    private Condition conditionB= lock.newCondition();
    private Condition conditionC= lock.newCondition();

    public  void A()  {
        lock.lock();
        try {
            while (num!=1){
                conditionA.await();
            }
            num=2;
            System.out.println(Thread.currentThread().getName()+"--->AAAAAAAAAAAAAAAAAAAAAA");
            conditionB.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public  void  B()  {
        lock.lock();
        try {
            while(num!=2){
                conditionB.await();
            }
            num=3;
            System.out.println(Thread.currentThread().getName()+"--->BBBBBBBBBBBBBBBBBB");
            conditionC.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public  void  C()  {
        lock.lock();
        try {
            while(num!=3){
                conditionC.await();
            }
            num=1;
            System.out.println(Thread.currentThread().getName()+"--->CCCCCCCCCCCCCCCCCCC");
            conditionA.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}

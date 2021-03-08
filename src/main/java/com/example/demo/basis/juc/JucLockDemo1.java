package com.example.demo.basis.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @Author liuxin
 * @Description //TODO
 **/
public class JucLockDemo1 {

    public static void main(String[] args) {
        TestBuy1 testBuy=new TestBuy1();

        new Thread(()->{ for(int i=0;i<60;i++) {
            testBuy.sale();
        }
        },"A").start();

        new Thread(()->{
            for(int i=0;i<60;i++){
                testBuy.sale();
            }
        }).start();
        new Thread(()->{
            for(int i=0;i<60;i++){
                testBuy.sale();
            }
        }).start();

    }

}



// lock三部曲
//
class TestBuy1{
    private int  nums=50;
    Lock lock=new ReentrantLock();

    public  void  sale(){
        lock.lock();
        lock.tryLock();



        try {
            System.out.println(Thread.currentThread().getName()+"卖出了"+(nums--)+"票,剩余了："+nums);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
        }
    }





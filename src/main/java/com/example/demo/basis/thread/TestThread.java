package com.example.demo.basis.thread;

import lombok.SneakyThrows;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @Author liuxin
 * @Description //TODO
 **/
public class TestThread {
    private final Lock lock = new ReentrantLock();
    private final Condition producerCondition = lock.newCondition();
    private final Condition consumerConditon = lock.newCondition();
    private final Queue<Object> queue = new ArrayBlockingQueue<>(10);
    @SneakyThrows
    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        Producer producer = testThread.new Producer();
        Consumer consumer = testThread.new Consumer();
        producer.start();
        consumer.start();
    }

    class Producer extends Thread{
        @Override
        public void run() {
            producer();
        }
        void producer(){
            try {
                lock.lock();
                for (;;){
                    if (queue.size() == 10){
                        System.out.println("生产者已满");
                        producerCondition.await();
                    }
                    queue.offer(new Object());
                    consumerConditon.signal();
                    System.out.println("生产者生产了一个值，目前队列数量为：" + queue.size());
                }
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }finally {
                lock.unlock();
            }
        }
    }

    class Consumer extends Thread{
        @Override
        public void run() {
            consumer();
        }
        void consumer(){
            try {
                lock.lock();
                for (;;){
                    if (queue.isEmpty()){
                        System.out.println("消费者资源已空");
                        consumerConditon.await();
                    }
                    queue.poll();
                    producerCondition.signal();
                    System.out.println("消费者消费了一个值，当前队列数量为: " + queue.size());
                }
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }finally {
                lock.unlock();
            }
        }
    }
}

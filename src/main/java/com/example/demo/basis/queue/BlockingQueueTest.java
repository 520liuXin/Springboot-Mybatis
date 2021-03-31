package com.example.demo.basis.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/*
 * @Author liuxin
 * @Description //TODO BlockingQueue 阻塞队列
 *
 *
 **/
public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        Test4();
    }





    /**
     * @description 测试抛出异常
     * @author liuxin
     * @date 2021/3/10 []
     * @return void
     **/
   static void test1(){
       ArrayBlockingQueue  blockingQueue=new ArrayBlockingQueue(3);

       System.out.println(blockingQueue.add("a"));
       System.out.println(blockingQueue.add("b"));
       System.out.println(blockingQueue.add("c"));

       // IllegalStateException: Queue full 抛出异常！
      // System.out.println(blockingQueue.add("d"));
       System.out.println("============================");
       System.out.println(blockingQueue.remove());
       System.out.println(blockingQueue.remove());
       System.out.println(blockingQueue.remove());
        // java.util.NoSuchElementException 抛出异常！
        // System.out.println(blockingQueue.remove());
   }


   /**
    * @description 测试不抛出异常，有返回值false
    * @author liuxin
    * @date 2021/3/10 []
    * @return void
    **/
   static void  Test2(){
       ArrayBlockingQueue  blockingQueue=new ArrayBlockingQueue(3);

       System.out.println(blockingQueue.offer("a"));
       System.out.println(blockingQueue.offer("b"));
       System.out.println(blockingQueue.offer("c"));

       // 返回false
       System.out.println(blockingQueue.offer("d"));
       System.out.println("============================");
       System.out.println(blockingQueue.poll());
       System.out.println(blockingQueue.poll());
       System.out.println(blockingQueue.poll());
       // 返回null
        System.out.println(blockingQueue.poll());

   }




    /**
     * @description 测测试等待，阻塞（一致阻塞）
     * @author liuxin
     * @date 2021/3/10 []
     * @return void
     **/
    static void  Test3() throws InterruptedException {
        ArrayBlockingQueue  blockingQueue=new ArrayBlockingQueue(3);

      blockingQueue.put("a");
        blockingQueue.put("c");
        blockingQueue.put("b");
        System.out.println("============================");

        //blockingQueue.put("b");

        System.out.println("============================");
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        // 等待
        System.out.println("============================");

        System.out.println(blockingQueue.take());

    }


    /**
     * @description 测测试等待，阻塞（等待超时）
     * @author liuxin
     * @date 2021/3/10 []
     * @return void
     **/
    static void  Test4() throws InterruptedException {
        ArrayBlockingQueue  blockingQueue=new ArrayBlockingQueue(3);

        System.out.println(blockingQueue.offer("a",2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("b",2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("c",2, TimeUnit.SECONDS));

        System.out.println("============================");

        System.out.println(blockingQueue.offer("d",2, TimeUnit.SECONDS));


        System.out.println("============================");
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
        // 等待
        System.out.println("============================");

        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));

    }

}

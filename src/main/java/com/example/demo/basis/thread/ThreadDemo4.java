package com.example.demo.basis.thread;

/*
 * @Author liuxin
 * @Description //TODO
 **/
public class ThreadDemo4 implements Runnable {

    private static  String winner;
    private  int seeps=10;
    @Override
    public void run() {

        for(int i=0;i<=seeps;i++){
            Boolean falg=gameOver(i);
            if(Thread.currentThread().getName().equals("兔子") && i%5==0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if(falg){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"-->跑了"+i+"步");
        }

    }

    private boolean gameOver(int steep){
        if(winner != null){
            return true;
        }{  if(steep >= seeps ){
                winner= Thread.currentThread().getName();
                System.out.println(winner+"获得了胜利");
                return true;
            }
        }
        return false;

    }


    public static void main(String[] args) {
        ThreadDemo4 threadDemo4=new ThreadDemo4();
        new Thread(threadDemo4,"兔子").start();
        new Thread(threadDemo4,"乌龟").start();

    }
}

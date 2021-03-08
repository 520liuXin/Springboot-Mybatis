package com.example.demo.basis.thread;

/*
 * @Author liuxin
 * @Description //TODO
 **/
public class ThreadStop implements Runnable{

    private boolean flag=true;
    @Override
    public void run() {
        while (flag){
            System.out.println("线程运行中");
        }

    }



    private void stop(){
        this.flag=false;

    }


    public static void main(String[] args) {
          ThreadStop threadStop=new ThreadStop();
          new Thread(threadStop).start();

          for(int i=0;i<100000;i++){
              System.out.println("main"+i);
              if(i==8000){
                  threadStop.stop();
                  System.out.println("线程停止");
              }


          }


    }
}

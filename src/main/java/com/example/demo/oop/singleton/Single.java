package com.example.demo.oop.singleton;


/*
 * @Author liuxin
 * @Description //TODO
 **/
public class Single {
    private  volatile static Single single;


    private  Single() {
    }
    
    public    static  Single getSingle(){
        if(single==null){
            synchronized (Single.class){
                single=new Single();
            }
        }
        return single;
    }
}

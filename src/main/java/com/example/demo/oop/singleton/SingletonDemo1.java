package com.example.demo.oop.singleton;

/*
 * @Author liuxin
 * @Description //TODO 通过静态内部类实现单例 -懒汉式
 **/
public class SingletonDemo1{

    //通过synchronized关键字实现单例模式
    private volatile static SingletonDemo1 singletonDemo1;

    public SingletonDemo1 getSingletonDemo1(){
        if(singletonDemo1==null){
            synchronized (SingletonDemo1.class){
                singletonDemo1=new SingletonDemo1();
            }
        }
        return singletonDemo1;
    }

}

//通过静态内部类实现单例
class  SingletonDemo2{
    //   /* 私有构造方法，防止被实例化,限制产生多个对象 */  
    private SingletonDemo2(){

    }
    /* 此处使用一个静态内部类来维护单例 */
    private static class  getSingletonDemo2{
        private static SingletonDemo2 singletonDemo2=new SingletonDemo2();
    }

    public static SingletonDemo2 getInstance(){
        return getSingletonDemo2.singletonDemo2;
    }
}


//饿汉式单例，初始化创建对象
class HungryMan{

    private HungryMan(){

    }
    private static final HungryMan hungry=new HungryMan();


    public  static HungryMan  getInstance(){
        return hungry;
    }
    
}

//通过枚举实现单例模式
enum Singletondemo2 {

    INSTANCE;

    public void doSomething() {
        System.out.println("doSomething");
    }


    //调用方式
    public static void main(String[] args) {
        Singletondemo2.INSTANCE.doSomething();
    }


}

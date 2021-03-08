package com.example.demo.basis.thread;

/*
 * @Author liuxin
 * @Description //TODO 静态代理详解
 **/
/**
   静态代理总结：
 真实对象和代理对象都要实现同一个接口
 代理对象需要代理真实角色
 好处：代理对象可以做很多真实对象做不了的事情
 真实对象可以专注于做自己的事情
 案例：
    你：真实角色
   婚庆公司：代理你，帮你处理结婚的事情
    结婚（接口）：实现结婚的接口即可
 **/

public class StaticProxy {

    public static void main(String[] args) {

        new Wedding(new You()).HaapyMarry();
        new Thread(()->System.out.println("我在")).start();

    }



    interface Marry{

        void HaapyMarry();
    }


    static class  You implements Marry{

        @Override
        public void HaapyMarry() {
            System.out.println("我准备结婚了");
        }
    }

    static class Wedding implements Marry{
        private Marry target;

        public Wedding(Marry target) {
            this.target = target;
        }

        @Override
        public void HaapyMarry() {
            before();
            target.HaapyMarry();
            after();
        }

        private void before() {
            System.out.println("结婚前准备");
        }

        private void after() {
            System.out.println("结婚后付款");
        }



    }



}

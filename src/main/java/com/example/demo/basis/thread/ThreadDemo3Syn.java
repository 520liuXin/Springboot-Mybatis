package com.example.demo.basis.thread;

/*
 * @Author liuxin
 * @Description //TODO
 **/
public class ThreadDemo3Syn {


    public static void main(String[] args) {
        Acount acount=new Acount("结婚基金",1000);
        Withdrawal withdrawal=new Withdrawal(acount,500,"刘信");
        Withdrawal withdrawal1=new Withdrawal(acount,1000,"思思");
        withdrawal.start();
        withdrawal1.start();

    }





    static class Acount{
        private String name;
        private int money;

        public Acount(String name,  int money) {
            this.name = name;
            this.money = money;
        }
    }

    //模拟银行进行取款
    static class  Withdrawal extends Thread{
        Acount acount;
        //取了多少钱
        int drawingMoney;
        //现在还剩多少钱
        int nowMoney;

        public Withdrawal(Acount acount, int drawingMoney,String name) {
            super(name);
            this.acount = acount;
            this.drawingMoney = drawingMoney;
        }

        @Override
        public void run() {

            synchronized (acount){
            //判断有没有钱<
            if(acount.money-drawingMoney<0){
                System.out.println(Thread.currentThread().getName()+"钱不够，无法取");
                return;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            acount.money-=drawingMoney;
            nowMoney+=drawingMoney;
            System.out.println(acount.name+"余额为"+acount.money);
            //Thread.currentThread().getName()=this.getName() 以为继承了Thread
            System.out.println(this.getName()+"手里的钱为："+nowMoney);
            }
        }
    }
}




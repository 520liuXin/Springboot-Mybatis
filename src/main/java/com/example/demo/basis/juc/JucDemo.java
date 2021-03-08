package com.example.demo.basis.juc;

/*
 * @Author liuxin
 * @Description //TODO 使用synchronized同步代码块进行加锁
 *
 **/
public class JucDemo {

    public static void main(String[] args) {
        TestBuy testBuy=new TestBuy();

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
        new Thread(()->{
            for(int i=0;i<60;i++){
                testBuy.sale();
            }
        }).start();

    }

}



//
class TestBuy{
    private int  nums=50;

    public  void  sale(){
        if(nums>0){
            synchronized(TestBuy.class){
                if(nums>0){
                    System.out.println(Thread.currentThread().getName()+"卖出了"+(nums--)+"票,剩余了："+nums);
                }
            }
            
            
        }
    }




}
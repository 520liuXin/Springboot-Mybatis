package com.example.demo.basis.lambad;

/*
 * @Author liuxin
 * @Description //TODO lambad表达式的实现
 **/
public class LambadDome1 {


    //3静态内部类
    static class Like1 implements ILike {
        @Override
        public void lambatTest(String name) {
            System.out.println(name + "喜欢lomba表达式-->3");
        }
    }
    public static void main(String[] args) {
        ILike like=new Like();
        like.lambatTest("刘信");


        ILike like1=new Like1();
        like1.lambatTest("刘信");


        //4局部内部类
        class Like2 implements ILike {
            @Override
            public void lambatTest(String name) {
                System.out.println(name + "喜欢lomba表达式-->4");
            }
        }
        ILike like2=new Like2();
        like2.lambatTest("刘信");


        //5 匿名内部类
        ILike like3=new ILike(){

            @Override
            public void lambatTest(String name) {
                System.out.println(name + "喜欢lomba表达式-->5");
            }
        };
        like3.lambatTest("刘信");

        //lambda表达式
        ILike like4=(String name)->System.out.println(name + "喜欢lomba表达式-->6");
        like4.lambatTest("刘信");



    }







}
//接口
interface ILike{

    void lambatTest(String name);
}

//实现类
 class Like implements ILike{
    @Override
    public void lambatTest(String name) {
        System.out.println(name+"喜欢lomba表达式-->1");
    }


}
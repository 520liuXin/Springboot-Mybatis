package com.example.demo.basis.demo;

/*
 * @Author liuxin
 * @Description //TODO
 **/
public class demo1 {
    static  class X{
        Y y=new Y();
        public X(){
            System.out.print("X");
        }
    }
    static class Y{
        public Y(){
            System.out.print("Y");
        }
    }
    public static class Z extends X{
        Y y=new Y();
        public Z(){
            System.out.print("Z");
        }
        public static void main(String[] args) {
            new Z();
        }
    }
}

package com.example.demo.basis.demo;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * @Author liuxin
 * @Description //TODO Atomic
 **/
public class demo1 {


    public static void main(String[] args) {
        Map<String,String> map=new ConcurrentHashMap<>();

        Map<String,String> map1=new Hashtable<>();
        Map<String,String> map2=new HashMap<>();

        System.out.println(2<<3);
        System.out.println(8>>1);


    }





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

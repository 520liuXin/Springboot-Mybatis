package com.example.demo.basis.list;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * @Author liuxin Collections.unmodifiableCollection
 * @Description //TODO 集合类的安全demo1
 **/
public class  ListDemo1 {


    public static void main(String[] args) {

        /**
         * 并发下，arrayList不安全,会报错ConcurrentModificationException 并发修改异常
         * 解决方法1：使用synchronized修饰的Vector方法         List<String> list=new Vector<>();
         * 解决方法2：         List<String> list= Collections.synchronizedList(new ArrayList<>());
         * 解决方案3： 使用lock进行写入时赋值         List<String> list= new CopyOnWriteArrayList<>();
         **/
        //List<String> list=new ArrayList<>();
        //List<String> list=new Vector<>();
        List<String> list= new LinkedList <>();

        for (int i=1;i<=20;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }


        //HashSet的底层就是HashMap，
        //Set<String> set= new HashSet<>();
        //add方法：return map.put(e, PRESENT)==null;利用map中的key不能相同
        Map<String,String> map=  Collections.synchronizedMap(new HashMap<>());
        Map<String,String> map1=new  ConcurrentHashMap<String, String>();

        Map<String,String> ma1= new Hashtable<>();




    }


}

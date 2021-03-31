package com.example.demo.basis.sortingalgorithm;

import com.example.demo.basis.arrays.ArrayDemo1;

import java.util.Arrays;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.swap;

/*
 * @Author liuxin
 * @Description //TODO 冒泡排序 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，
 *                 一次比较两个元素，如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，
 *              也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
 **/
public class BubbleSort {

    public static void main(String[] args) {

        int[] arrays=new int[10];
        int[] arrays1={1,6,9,44,5,5};
        sort(arrays1);
       ArrayDemo1.printArrays(arrays1);

    }






    private static void sort(int[] arrays){
        int n=arrays.length;

        for (int i=0;i<n-1;i++){
            int temp;
            //使用标识符减少不必要的循环次数
            boolean flag=false;
            for(int j=0;j<n-i-1;j++){
                if(arrays[j]>arrays[j+1]){
                    swap(arrays,j,j+1);
                    flag=true;
                }
            }  if(!flag){
                break;
            }

        }
    }

}

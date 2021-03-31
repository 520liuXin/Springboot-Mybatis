package com.example.demo.basis.sortingalgorithm;

import com.example.demo.basis.arrays.ArrayDemo1;
import lombok.experimental.var;

import static org.apache.ibatis.ognl.OgnlOps.less;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.swap;

/*
 * @Author liuxin
 * @Description //TODO 希尔排序
 **/
/**算法描述

 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：

 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 按增量序列个数k，对序列进行k 趟排序；
 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 */
public class ShellSort {


    public static void main(String[] args) {
        int[] arrays1={1,6,9,44,5,5};
        sort(arrays1,2);
        ArrayDemo1.printArrays(arrays1);
    }


    private static void sort(int[] nums,int n){
        int N = nums.length;
        int gap = 1;

        while (gap < N / n){
            gap = n * gap + 1;
        }
        while (gap >= 1){
            for (int i = gap;i < N ; i ++){
                for (int j = i;j >= gap && less(nums[j],nums[j - gap]);j -= gap){
                    swap(nums,j,j-gap);
                }
            }
            gap = gap/ n;
        }
    }

}

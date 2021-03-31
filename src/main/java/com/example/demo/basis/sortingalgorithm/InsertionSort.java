package com.example.demo.basis.sortingalgorithm;

import com.example.demo.basis.arrays.ArrayDemo1;

/*
 * @Author liuxin
 * @Description //TODO 插入排序 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 **/
/**
 算法描述

 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：

 从第一个元素开始，该元素可以认为已经被排序；
 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 将新元素插入到该位置后；
 重复步骤2~5。

 **/
public class InsertionSort {


    public static void main(String[] args) {

        int[] arrays=new int[10];
        int[] arrays1={1,6,9,44,5,5};
        sort(arrays1);
        ArrayDemo1.printArrays(arrays1);

    }


//插入排序
    private static void sort(int[] arrays) {
        int n = arrays.length;
        //
        int preIndex, current;

        for (int i = 1; i < n; i++) {
            preIndex = i - 1;
            current = arrays[i];
            while (preIndex >= 0 && arrays[preIndex] > current) {
                arrays[preIndex + 1] = arrays[preIndex];
                preIndex--;
            }
            arrays[preIndex + 1] = current;
        }


    }
}

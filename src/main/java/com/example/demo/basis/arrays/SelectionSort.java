package com.example.demo.basis.arrays;

/*
 * @Author liuxin
 * @Description //TODO 选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，
    *              存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，
     *              然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 **/
public class SelectionSort {


    public static void main(String[] args) {

        int[] arrays=new int[10];
        int[] arrays1={1,6,9,44,5,5};
        for (int i=0;i< arrays.length;i++){
            arrays[i]=i;
        }
        // printArrays(bubbleSort(arrays1));
       ArrayDemo1.printArrays(SelectionSort(arrays1));

    }

    public static int[] SelectionSort(int[] arrays) {
        int n = arrays.length;
        int temp;
        int min;
        for (int i = 0; i < n - 1; i++) {
            min = i;
            for (int j = i + 1; j < n; j++) {
                if (arrays[min] > arrays[j]) {
                    min = j;
                }
            }
            temp = arrays[i];
            arrays[i] = arrays[min];
            arrays[min] = temp;
        }
        return arrays;
    }
}

package com.example.demo.basis.sortingalgorithm;

import com.example.demo.basis.arrays.ArrayDemo1;

import static org.apache.ibatis.ognl.OgnlOps.less;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.swap;

/*
 * @Author liuxin
 * @Description //TODO 快速排序
 **/
/**算法描述 超级

 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：

 从数列中挑出一个元素，称为 “基准”（pivot）；
 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序*/
public class QuickSort {


    public static void main(String[] args) {
        int[] arrays1={1,6,9,44,5,5};
        quick_sort(arrays1,0,arrays1.length-1);
        ArrayDemo1.printArrays(arrays1);
    }

    static void quick_sort(int arr[],int left,int right) {
        // 左游标大于等于右游标
        if (left >= right) {
            return;
        }
        // 左游标
        int i = left;
        // 右游标
        int j = right + 1;
        // 将最左边的元素，作为分界值（枢纽）
        int key = arr[left];
        while (true) {
            while (arr[++i] < key) {
                if (i == right) {
                    break;
                }
            }
            while (arr[--j] > key) {
                if (j == left) {
                    break;
                }
            }
            // 退出死循环
            if (i >= j) {
                break;
            }
            // 交换左、右游标指向的数
            swap(arr, i, j);
        }
        // 交换左边界值与左游标指向的值
        swap(arr,left,j);
        // 递归处理分界值左边的部分
        quick_sort(arr, left, j - 1);
        // 递归处理分界值右边的部分
        quick_sort(arr, j + 1, right);
    }

}

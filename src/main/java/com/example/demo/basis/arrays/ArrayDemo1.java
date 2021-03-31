package com.example.demo.basis.arrays;

/*
 * @Author liuxin
 * @Description //TODO
 **/
public class ArrayDemo1 {
    public static void main(String[] args) {

        int[] arrays = new int[10];
        int[] arrays1 = {1, 6, 9, 44, 5, 5};
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = i;
        }
        // printArrays(bubbleSort(arrays1));
        printArrays(bubbleSort1(arrays1));

    }

    //冒泡排序
    private static int[] bubbleSort1(int[] arrays) {
        int temp;
        for (int i = 0; i < arrays.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arrays.length - 1 - i; j++) {
                if (arrays[j + 1] < arrays[j]) {
                    temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return arrays;

    }

    /**
     * @return void
     * @description 打印数组内容
     * @author liuxin
     * @date 2021/2/27 [arrays]
     **/
    public static void printArrays(int[] arrays) {
        for (int array : arrays) {
            System.out.print(array + " ");
        }

    }

    /**
     * @return
     * @description 反转数组
     * @author liuxin
     * @date 2021/2/27
     **/
    public static int[] reverseArrays(int[] arrays) {
        int[] res = new int[arrays.length];

        for (int i = 0, j = arrays.length - 1; i < arrays.length; i++, j--) {
            res[j] = arrays[i];
        }
        return res;

    }


    /**
     * @return
     * @description 冒泡排序
     * @author liuxin
     * @date 2021/2/27
     **/
    public static int[] bubbleSort(int[] arrays) {
        int temp;

        for (int i = 0; i < arrays.length - 1; i++) {

            boolean flag = false;

            for (int j = 0; j < arrays.length - 1 - i; j++) {
                if (arrays[j + 1] < arrays[j]) {
                    temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return arrays;
    }

    /**
     * @return
     * @description 选择排序 produce
     * @author liuxin
     * @date 2021/2/27
     **/
    public static int[] selectSort(int[] arrays) {
        int temp;

        for (int i = 0; i < arrays.length - 1; i++) {

            boolean flag = false;

            for (int j = 0; j < arrays.length - 1 - i; j++) {
                if (arrays[j + 1] < arrays[j]) {
                    temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                    flag = true;
                }
            }

        }
        return arrays;
    }



}

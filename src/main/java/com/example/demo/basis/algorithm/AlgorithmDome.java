package com.example.demo.basis.algorithm;

import com.example.demo.basis.arrays.ArrayDemo1;

import java.util.*;

/*
 * @Author liuxin
 * @Description //TODO 三数之和
 *  给定一个包含n个整数的数组，在数组中是否存在a、b、c元素使得a + b + c = 0?找出数组中所有唯一的三个数组合，它们的和为零。
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [ [-1, 0, 1], [-1, -1, 2]]
 **/
       /* * 解题思路：
         *      首先我们对数组进行排序，然后定义两个指针，
         *      分别指向 当前遍历索引的 下一个 和 数组 最后一个元素的索引位置
         *      在计算的过程当中，我们需要防止重复数字的重复计算。
         */
public class AlgorithmDome {


    public static List<List<Integer>>  threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //判断是否个数是否小于三
        if (nums.length < 3) {
            return lists;
        }
        //排序
        Arrays.sort(nums);
        int n = nums.length;
        //定义一个和为0
        int sum = 0;
        //循环遍历数组，只需要遍历长度-2（nums.length-2）次
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                //如果当前这个数 num > 0 循环结束
                break;
            }
            //防止相同数字重复计算，造成结果相同,结束当前循环
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //设置边界值  起始 结束
            int begInt = i + 1;
            int endInt = n - 1;
            //循环
            while (begInt < endInt) {
                sum = nums[i] + nums[begInt] + nums[endInt];
                //如果总和为0，则将其添加至list中
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[begInt], nums[endInt]));
                    //防止相同数字重复计算，造成结果相同
                    while (begInt < endInt && nums[begInt] == nums[begInt + 1]) {
                        begInt++;
                    }
                    //防止相同数字重复计算，造成结果相同
                    while (begInt < endInt && nums[endInt] == nums[endInt - 1]) {
                        endInt--;
                    }
                    begInt++;
                    endInt--;
                } else if (sum < 0) {
                    begInt++;
                } else {
                    endInt--;
                }
            }
        }
        return lists;
    }


    //l两数之和
    //nums = [2,7,11,15], target = 9
    public static int[] twoSum(int[] nums, int target) {
              int n=nums.length;
              for (int i=0;i<n-1;i++){
                  for (int j=i+1;j<n;j++){
                      if (target==nums[i]+nums[j]) {
                          return new int[]{i,j};
                      }
                  }
              }
        return new int[0];

    }
    //示例2
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }


    public static void main(String[] args) {
        System.out.println("进入程序");
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        List<List<Integer>> lists =threeSum(nums);
//
//        System.out.println("输出的值"+lists);
        int[] nums1 = {7,11,15,2};
        int[] res=twoSum(nums1,9);
        System.out.println(Arrays.toString(res));



    }

}

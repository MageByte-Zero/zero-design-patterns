package com.zero.algorithm;

import java.util.Arrays;

/**
 * @author jianqing.li
 * @date 2018/7/19
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {7, 18, 99, 12, 33, 45, 11, 77, 43, 2};
        SelectSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序是一种简单直观的排序算法，其基本原理如下：对于给定的一组记录，经过第一轮比较后得到最小的记录，然后将该记录的位置
     * 与第一个记录的位置交换；接着对不包括第一个记录以外的其他记录进行第二次比较，得到最小记录并与第二个位置记录交换；重复该过程
     * ，知道进行比较的记录只剩下一个为止。
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            // 选择用于比较的数
            int select = arr[i];
            // 假设当前下标为最小值的下标
            int flag = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 找到比select更小的数则交换，这样就能找到最小的那个数
                if (arr[j] < select) {
                    select = arr[j];
                    flag = j;
                }
            }
            // 找到最小数后交换数据,将arr[i]与最小数交换
            if (flag != i) {
                arr[flag] = arr[i];
                arr[i] = select;
            }
        }

    }
}

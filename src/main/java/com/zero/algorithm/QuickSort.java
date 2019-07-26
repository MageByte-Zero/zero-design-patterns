package com.zero.algorithm;

import java.util.Arrays;

/**
 * @author jianqing.li
 * @date 2018/7/19
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {7, 18, 99, 12, 33, 45, 11, 77, 43, 2};
        int[] sort = quickSort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(sort));
    }

    /**
     * 1．i =L; j = R; 将基准数挖出形成第一个坑a[i]。
     * <p>
     * 2．j--由后向前找比它小的数，找到后挖出此数填前一个坑a[i]中。
     * <p>
     * 3．i++由前向后找比它大的数，找到后也挖出此数填到前一个坑a[j]中。
     * <p>
     * 4．再重复执行2，3二步，直到i==j，将基准数填入a[i]中。
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public int[] sort(int[] arr, int left, int right) {
        if (left < right) {
            // 挖出第一个坑arr[left]作为基准数
            int i = left, j = right, x = arr[left];
            while (i < j) {
                // 从后往前找比x小的数
                while (i < j && arr[j] > x) {
                    j--;
                }
                // 找到后使用该数据去填arr[i]
                if (i < j) {
                    // 将j的数据填到arr[i]
                    arr[i++] = arr[j];
                }

                // 从前往后找比x大于，等于的数
                while (i < j && arr[i] < x) {
                    i++;
                }
                // 找到后去填上一个挖出的坑arr[j]
                if (i < j) {
                    arr[j--] = arr[i];
                }

            }
            //当i=j的时候，将x填入当前坑中
            arr[i] = x;
            // 递归调用
            sort(arr, left, i - 1);
            sort(arr, i + 1, right);
        }
        return arr;
    }
}

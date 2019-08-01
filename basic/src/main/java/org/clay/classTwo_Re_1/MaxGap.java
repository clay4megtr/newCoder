package org.clay.classTwo_Re_1;

import java.util.Arrays;

public class MaxGap {

    public static Integer maxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int len = arr.length;
        int min_value = Integer.MAX_VALUE;
        int max_value = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            min_value = Math.min(min_value,arr[i]);
            max_value = Math.max(max_value,arr[i]);
        }
        if (min_value == max_value) {//最大值和最小值相等，返回0
            return 0;
        }

        int[] mins = new int[arr.length+1];
        int[] maxs = new int[arr.length+1];
        boolean[] hasNum = new boolean[arr.length+1];

        for(int i = 0; i < arr.length; i++){
            int bid = bucket(arr[i],arr.length,min_value,max_value);
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid],arr[i]) : arr[i];//对应的桶中存在的最大值。
            mins[bid] = hasNum[bid] ? Math.min(mins[bid],arr[i]) : arr[i];//对应的桶中存在的最小值。
            hasNum[bid] = true;//对应的桶中存入值了。
        }

        //上一个桶的最大值
        int last_max = maxs[0];
        int res = 0;

        for(int i = 1; i <= len; i++){
            if(hasNum[i]){
                //就和上一次非空桶的最大值相减
                res = Math.max(res,mins[i] - last_max);  //和上一次取得的结果进行比较，取大的。
                last_max = maxs[i];  //把lastMax置为当前桶的最大值，供下一个非空桶的最小值相减。
            }
        }

        return res;
    }

    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }

    // for test
    public static int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (maxGap(arr1) != comparator(arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}

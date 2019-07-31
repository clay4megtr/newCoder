package org.clay.classTwo;

import java.util.Arrays;
import java.util.Map;

/**
 * 数组
 * 寻找排序后相邻两数字的最大差值
 * 不能使用比较排序。
 */
public class Code_11_MaxGap {

    public static int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;//  min 初始化为最大值。
        int max = Integer.MIN_VALUE;//  max 初始化为最小值。

        for(int i = 0; i < nums.length; i++){   //遍历找到数组中的最大值和最小值
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }
        if (min == max) {//最大值和最小值相等，返回0
            return 0;
        }

        /**
         * 定义三个数组，分别代表桶的三个属性
         * hasNum：桶中是否有值
         * maxs：当前桶的最大值
         * mins：当前桶的最小值
         */
        boolean hasNum[] = new boolean[len + 1];//默认是false
        int maxs[] = new int[len + 1];//默认是0
        int mins[] = new int[len + 1];//默认是0
        int bid;//桶号
        for(int i = 0; i < len; i++){
            bid = bucket(nums[i], len, min, max);//属于哪个桶
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid],nums[i]) : nums[i];//对应的桶中存在的最大值。
            mins[bid] = hasNum[bid] ? Math.min(mins[bid],nums[i]) : nums[i];//对应的桶中存在的最小值。
            hasNum[bid] = true;//对应的桶中存入值了。
        }
        /**
         * 此时对应的数字都放到了对应的桶中，且每个桶的三个属性值也都填好了。
         */

        int lastMax = maxs[0];  //上一个非空桶的最大值。
        int res = 0;

        //开始遍历所有的桶（N+1个）查找相邻的最大值。
        //从1号桶从开始比较，0号桶不用比较。
        for(int i = 1; i <= nums.length; i++){  //因为桶的个数是N+1个，所以终止条件是 <= nums.length;
            if(hasNum[i]){//当前桶中有值
               //就和上一次非空桶的最大值相减
                res = Math.max(res,mins[i] - lastMax);  //和上一次取得的结果进行比较，取大的。
                lastMax = maxs[i];  //把lastMax置为当前桶的最大值，供下一个非空桶的最小值相减。
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

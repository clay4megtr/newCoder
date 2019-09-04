package org.clay.basic_class_02_Re;

import java.util.HashMap;

/**
 * 数组中累加和为aim的最长子数组的长度
 */
public class MaxLergthSubArray {

    public static int process(int[] arr,int aim){

        int max = Integer.MIN_VALUE;

        //key 累加和，  value： 累加和第一次出现的位置
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);


        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
            if(map.get(sum) == null){
                map.put(sum,i);
            }
            if(map.get(sum - aim) != null){
                max = Math.max(i - map.get(sum - aim) + 1,max);
            }
        }

        return max;
    }


    public static void main(String[] args) {

        int[] arr = new int[]{7,3,2,1,1,7,-6,-1,7};
        System.out.println(process(arr,7));
    }
}

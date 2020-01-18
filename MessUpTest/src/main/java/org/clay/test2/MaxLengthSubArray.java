package org.clay.test2;

import java.util.HashMap;
import java.util.Map;

/**
 *  累加和为aim的最长子数组长度
 *  1.有正有负
 *  2.只有正
 */
public class MaxLengthSubArray {

    /**
     * 有正有负
     */
    public static int process1(int[] arr, int target){

        int res = 0;

        Map<Integer,Integer> map = new HashMap<>();  //key是累加和，value是这个累加和最早出现的位置
        map.put(0,-1);

        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            int diff = target - sum;
            if(map.get(diff) != null){
                res = Math.max(res,i - map.get(diff));
            }
        }

        return res;
    }

    /**
     * 都是正数
     */
    public static int process2(int[] arr,int target){

        int len = 0;
        int L = 0;
        int R = 0;

        int sum = arr[0];

        while(R < arr.length){
            if(sum < target){
                R++;
                if(R == arr.length){
                    break;
                }
                sum += arr[R];
            }else if(sum == target){
                len = Math.max(len,R - L + 1);
                sum -= arr[L++];
            }else{
                sum -= arr[L++];
            }
        }
        return len;
    }



    public static void main(String[] args) {

        int[] arr = new int[]{5,2,-3,4,6,-1};
        System.out.println(process1(arr,3));

        int[] arr1 = new int[]{3,4,2,1,2,1,7,4};
        System.out.println(process2(arr1,10));
    }
}

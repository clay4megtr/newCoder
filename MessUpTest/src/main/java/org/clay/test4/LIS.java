package org.clay.test4;

import java.util.Arrays;

/**
 * 最长递增子序列
 */
public class LIS {


    //根据dp数组生成最长递增子序列
    public static int[] generate(int[] arr){

        int[] dp = getDp(arr);

        int len = Integer.MIN_VALUE;
        int index = 0;

        for(int i = 0; i < dp.length; i++){
            if(dp[i] > len){
                len = dp[i];
                index = i;
            }
        }

        int[] res = new int[len];
        res[--len] = arr[index];

        for(int i = index; i > 0; i--){
            if(arr[i-1] < arr[i] && dp[i-1] + 1 == dp[i]){
                res[--len] = arr[i-1];
            }
        }
        return res;
    }

    //生成dp数组
    public static int[] getDp(int[] arr){

        int[] dp = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        return dp;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{6,2,1,3,5,4,9,7};
        int[] res = generate(arr);

        Arrays.stream(res).forEach(System.out::println);
    }


}

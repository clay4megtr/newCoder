package org.clay.classEight_Re;

public class SubArrayMaxNum {


    public static int maxSum(int[] arr){

        int cur = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            cur += arr[i];
            max = cur > max ? cur : max;
            if(cur < 0){
                cur = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[] arr1 = { -2, -3, -5, 40, -10, -10, 100, 1 };
        System.out.println(maxSum(arr1));
    }
}
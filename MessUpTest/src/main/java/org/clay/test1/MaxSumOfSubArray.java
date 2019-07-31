package org.clay.test1;

public class MaxSumOfSubArray {

    public static int getSum(int[] arr){

        int cur = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            cur += arr[i];
            max = Math.max(max,cur);
            if (cur < 0){
                cur = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{ -2, -3, -5, 40, -10, -10, 100, 1 };
        System.out.println(getSum(arr));
    }
}

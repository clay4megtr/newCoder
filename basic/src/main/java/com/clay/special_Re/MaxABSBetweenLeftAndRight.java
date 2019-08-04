package com.clay.special_Re;

public class MaxABSBetweenLeftAndRight {

    public static int getMax(int[] arr){

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            max = Math.max(max,arr[i]);
        }

        return max - Math.min(arr[0],arr[arr.length-1]);
    }
}

package com.clay.special_Re;

public class FindOneLessValueIndex {

    public static int getLocalMin(int[] arr){

        if(arr == null || arr.length == 0){
            return -1;
        }

        if(arr.length == 1 || arr[0] < arr[1]){
            return arr[0];
        }

        if(arr[arr.length-1] < arr[arr.length-2]){
            return arr[arr.length-1];
        }

        int left = 0;
        int right = arr.length;
        int mid = 0;

        while(left < right){
            mid = (left + right) / 2;

            if(arr[mid] > arr[mid-1]){
                right = mid;
            }else if(arr[mid] > arr[mid+1]){
                left = mid;
            }else{
                return mid;
            }
        }

        return left;
    }
}

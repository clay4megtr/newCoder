package com.clay.special_Re;

public class FindOneLessValueIndex {

    public static int getLocalMin(int[] arr){

        if(arr.length == 1){
            return arr[0];
        }

        if(arr[0] < arr[1]){
            return arr[0];
        }

        if(arr[arr.length-1] < arr[arr.length-2]){
            return arr[arr.length-1];
        }
        //length must > 2

        int left = 1;
        int right = arr.length - 2;

        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] > arr[mid-1]){
                right = mid - 1;
            }else if(arr[mid] > arr[mid+1]){
                left = mid + 1;
            }else{
                return arr[mid];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,10,3,2,4,6};
        System.out.println(getLocalMin(arr));
    }
}

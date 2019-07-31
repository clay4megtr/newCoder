package org.clay.review;

/**
 * 二分查找
 */
public class BinarySearch {

    /**
     * 迭代法实现
     */
    public int bs1(int[] arr,int target){

        int start = 0;
        int end = arr.length-1;
        int mid;

        while(start <= end){

            mid = (start + end) / 2;

            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 递归法实现
     */
    public int bs2(int[] arr,int start,int end,int target){

        int mid = start + (end-start) / 2;

        if(target == arr[mid]){
            return mid;
        }

        if(start >= end){
            return -1;
        }
        if(target > arr[mid]){
            return bs2(arr,mid+1,end,target);
        }
        if(target < arr[mid]){
            return bs2(arr,start,mid,target);
        }

        return -1;
    }

}

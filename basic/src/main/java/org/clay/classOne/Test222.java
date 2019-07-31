package org.clay.classOne;

/**
 * 在一个数组中找最大值
 * 最简单的分治思想，左边的最大值，右边的最大值，两个比较大的内个就是整个数组的最大值
 */
public class Test222 {

    public static int getMax(int[] arr, int L, int R){

        if(L == R){
            return arr[L];
        }

        int mid = (L + R) / 2;   // 中间位置

        int maxLeft = getMax(arr,L,mid);
        int maxRight = getMax(arr,mid + 1,R);
        return Math.max(maxLeft,maxRight);
    }

    public static void main(String[] args) {

        int[] arr = {4,3,2,1};
        System.out.println(getMax(arr,0,arr.length-1));
    }
}

package org.clay.test1;

import java.util.Map;

public class Test1 {

    public static Integer bucketing(int[] arr){

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++){
            max = arr[i] > max ? arr[i] : max;
            min = arr[i] < min ? arr[i] : min;
        }

        if (min == max) {//最大值和最小值相等，返回0
            return 0;
        }

        boolean[] hasNums = new boolean[arr.length+1];
        int[] maxs = new int[arr.length+1];
        int[] mins = new int[arr.length+1];

        for(int i = 0; i < arr.length; i++){
            int bid = bucket(arr[i],arr.length,min,max);
            maxs[bid] = hasNums[bid] ? Math.max(maxs[bid],arr[i]) : arr[i];
            mins[bid] = hasNums[bid] ? Math.min(mins[bid],arr[i]) : arr[i];
            hasNums[bid] = true;
        }

        int lastMax = maxs[0];
        int res = 0;

        for (int i = 1; i <= arr.length; i++){
            if(hasNums[i]){
                res = Math.max(res,mins[i]-lastMax);
                lastMax = maxs[i];
            }
        }

        return res;
    }

    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }


    public static void heapSort(int[] arr){

        for(int i = 1; i < 0; i++){
            heapInsert(arr,i);
        }

        int heapSize = arr.length;
        swap(arr,0,--heapSize);

        while(heapSize > 0){
            heapify(arr,heapSize,0);
            swap(arr,0,--heapSize);
        }
    }

    private static void heapify(int[] arr, int heapSize,int index) {

        int left = 2 * index + 1;

        while(left < heapSize){

            int lagest = (left+1 < heapSize) && (arr[left+1] > arr[left]) ? left+1 : left;

            lagest = arr[lagest] < arr[index] ? index : lagest;

            if(lagest == index){
                break;
            }
            swap(arr,lagest,index);
            index = lagest;
            left = 2 * index + 1;
        }
    }

    private static void heapInsert(int[] arr, int index) {

        while(arr[index] > arr[(index-1) / 2]){
            swap(arr,index,(index-1) / 2);
            index = (index-1) / 2;
        }
    }

    public static void swap(int[] arr, int i, int j){

        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5};
        int in = 3;
        for(int i = 0; i < arr.length; i++){
            while(in > 0){
                in--;
                if(in == 1){
                    System.out.println("break");
                    break;
                }
            }
            System.out.println(arr[i]);
        }
    }
}

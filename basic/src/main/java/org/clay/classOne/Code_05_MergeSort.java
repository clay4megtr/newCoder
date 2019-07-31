package org.clay.classOne;

import java.util.Arrays;

/**
 *  冒泡，选择，插入，时间复杂度高的原因：
 *  浪费比较次数，每次一轮循环的比较，都只找出一个数。
 *
 *  归并时间复杂度低的原因。
 *  小范围合并大范围的过程中，也就是merge的过程中，是利用了外排序。
 *  不会浪费两个已经排好序的数组的比较次数，
 *  小范围组内排序被利用起来了。
 *  O(n * logN)
 *  空间复杂度：O（N）
 */
public class Code_05_MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = (l + r) / 2;

        // 把左部分排好
        mergeSort(arr,l,mid);

        // 把右部分排好
        mergeSort(arr,mid+1,r);

        // 左右部分都排好了，但整体还是无序的，merge 就是让他们整体有序
        merge(arr,l,mid,r);
    }

    /**
     * 外排序
     * 注意点：很多地方都是从L开始，是针对子数组排序，
     * 所以不是从0开始。
     *
     * 函数功能：让整体有序
     */
    private static void merge(int[] arr, int l,int mid, int r) {

        int[] help = new int[r - l + 1];//辅助数组的作用：承接排好序的数组。不能直接覆盖原数组。
        int i = 0;
        int p1 = l;         //注意点：这里是从l开始
        int p2 = mid+1;

        while(p1 <= mid && p2 <= r){
            if(arr[p1] < arr[p2]){
                help[i++] = arr[p1++];
            }else{
                help[i++] = arr[p2++];
            }
        }

        while(p1 <= mid){
            help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }

        for(i = 0; i < help.length; i++){
            arr[l++] = help[i];//这里为什么是[l + i]？  画一下树形图就知道了，每次是把两个在固定位置的子数组merge。
        }
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
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
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
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
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        mergeSort(arr);
        printArray(arr);

    }
}

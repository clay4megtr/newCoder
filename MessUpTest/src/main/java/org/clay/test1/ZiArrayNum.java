package org.clay.test1;

import java.util.LinkedList;

public class ZiArrayNum {

    /**
     * 最大值减去最小值小于或等于num的子数组的数量
     */
    public static int getNum(int[] arr,int num){

        LinkedList<Integer> qMax = new LinkedList<>();
        LinkedList<Integer> qMin = new LinkedList<>();

        int start = 0;
        int end = 0;
        int res = 0;

        while(start < arr.length){

            while(end < arr.length){

                while(! qMax.isEmpty() && arr[qMax.peekLast()] <= arr[end]){
                    qMax.pollLast();
                }
                qMax.addLast(end);

                while(! qMin.isEmpty() && arr[qMin.peekLast()] >= arr[end]){
                    qMin.pollLast();
                }
                qMin.addLast(end);

                if(arr[qMax.getFirst()] - arr[qMin.getFirst()] > num){
                    break;
                }

                end++;
            }
            res += end-start;

            //过期
            if(qMax.peekFirst() == start){
                qMax.pollFirst();
            }

            if(qMin.peekFirst() == start){
                qMin.pollFirst();
            }

            start++;
        }
        return res;
    }

    // for test
    public static int[] getRandomArray(int len) {
        if (len < 0) {
            return null;
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,5};
        int num = 1;
        //printArray(arr);
        System.out.println(getNum(arr, num));
    }
}

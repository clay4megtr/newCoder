package org.clay.advanced_class_02;

import java.util.LinkedList;

public class Code_03_AllLessNumSubArray {

    public static int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<Integer>(); // 最小值更新结构
        LinkedList<Integer> qmax = new LinkedList<Integer>(); // 最大值更新结构
        int start = 0;
        int end = 0;
        int res = 0;
        while (start < arr.length) {//i是开头

            //while循环的作用：start固定，end扩到不能再扩了，停；
            while (end < arr.length) {//j是窗口最右侧位置，再往右一个
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[end]) {  //最小值结构更新
                    qmin.pollLast();
                }
                qmin.addLast(end);
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[end]) {  //最大值结构更新
                    qmax.pollLast();
                }
                qmax.addLast(end);
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    break;  // 不达标就break
                }
                end++;
            }

            if (qmin.peekFirst() == start) { //最小值的更新结构看看有没有过期
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == start) { //最大值的更新结构看看有没有过期
                qmax.pollFirst();
            }
            res += end - start; //一次性获得了所有以start位置为头，达标的数量；
            start++;    //换一个开头
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
        int[] arr = getRandomArray(30);
        int num = 5;
        printArray(arr);
        System.out.println(getNum(arr, num));
    }
}

package org.clay.test1;

import java.util.LinkedList;

public class WindowMaxValue {

    public static int[] getMaxWindow(int[] arr, int w) {//w窗口大小
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<Integer>();  // 只存下标
        int[] res = new int[arr.length - w + 1];//总共收集的结果
        int index = 0;//res[index]写入index
        for (int i = 0; i < arr.length; i++) {//i表示窗口R
            //准备存入i位置的arr[i]
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {  //尾部的值小于等于当前值；
                qmax.pollLast();//就从尾部弹出，
            }
            qmax.addLast(i);    //加入arr[i]到尾部
            if (qmax.peekFirst() == i - w) {//如果头部已经要过期了  i - w表示过期的下标
                qmax.pollFirst();//如果已经到窗口极限了，弹出头部，L开始右移动
            }
            if (i >= w - 1) {//当窗口已经形成了，记录每一步的res
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static int[] getWindowMaxValue(int[] arr, int w) {

        int[] res = new int[arr.length - w + 1];

        LinkedList<Integer> queue = new LinkedList<>();  //存的是索引

        int index = 0;
        for (int i = 0; i < arr.length; i++) {

            while(!queue.isEmpty() && queue.peekLast() < arr[i]){
                queue.pollLast();
            }
            queue.addLast(i);

            if(queue.peekFirst() == i-w){
                queue.pollFirst();
            }
            if(i >= w-1){
                res[index++] = arr[queue.peekFirst()];
            }
        }

        return res;
    }

    // for test
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int w = 3;
        printArray(getMaxWindow(arr, w));
        printArray(getWindowMaxValue(arr, w));
    }
}
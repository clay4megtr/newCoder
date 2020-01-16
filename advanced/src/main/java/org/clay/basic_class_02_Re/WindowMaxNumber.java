package org.clay.basic_class_02_Re;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值问题
 */
public class WindowMaxNumber {


    public static int[] getMaxNumber(int[] arr, int window_length) {

        int[] res = new int[arr.length - window_length + 1];
        int index = 0;  //res的索引

        LinkedList<Integer> queue = new LinkedList<>();  // 注意存的是index

        for(int i = 0; i < arr.length; i++){

            while (!queue.isEmpty()){
                if(arr[queue.peekLast()] < arr[i]){
                    queue.pollLast();
                }else{
                    break;
                }
            }
            queue.addLast(i);

            if(i >= window_length - 1){   //开始产生窗口内最大值
                res[index++] = arr[queue.peekFirst()];
                if(queue.peekFirst() == i - window_length + 1){   // 如何判断是否过期了
                    queue.pollFirst();
                }
            }
        }
        return res;
    }

    public static void printArr(int[] arr) {
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,4,1,2,6,5,6};
        printArr(getMaxNumber(arr, 3));
    }
}

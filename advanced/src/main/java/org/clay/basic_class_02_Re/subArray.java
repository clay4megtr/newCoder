package org.clay.basic_class_02_Re;

import java.util.LinkedList;

/**
 * 符合最大值减去最小值<=num的子数组的个数
 */
public class subArray {


    public static int getSubArrayNum(int[] arr, int num){

        int L = 0;
        int R = 0;
        int res = 0;

        LinkedList<Integer> max = new LinkedList<>();  //最小值更新窗口
        LinkedList<Integer> min = new LinkedList<>();  //最大值更新窗口

        while (L < arr.length){

            while(R < arr.length){

                while(!max.isEmpty() && arr[R] > arr[max.peekLast()] ){
                    max.pollLast();
                }
                max.addLast(R);

                while(!min.isEmpty() && arr[R] < arr[min.peekLast()]){
                    min.pollLast();
                }
                min.addLast(R);

                if(arr[max.peekFirst()] - arr[min.peekFirst()] > num){
                    break;
                }
                R++;
            }

            if(max.peekFirst() == L){
                max.pollFirst();
            }
            if(min.peekFirst() == L){
                min.pollFirst();
            }

            res += R - L;
            L++;
        }

        return res;
    }
}

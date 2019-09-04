package org.clay.basic_class_02_Re;

/**
 * 排成一条线的纸牌博弈问题
 */
public class Win {

    //在begin和end之前先拿
    public static int f(int[] arr,int begin, int end){
        if(begin == end){
            return arr[begin];
        }

        return Math.max(arr[begin] + s(arr,begin+1,end),arr[end] + s(arr,begin,end-1));
    }

    //在begin和end之间后拿
    public static int s(int[] arr,int begin, int end){

        if(begin == end){
            return 0;
        }

        return Math.min(f(arr,begin+1,end),f(arr,begin,end-1));
    }
}

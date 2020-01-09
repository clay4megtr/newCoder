package org.clay.review;

/**
 * 冒泡排序的优化
 */
public class BubbleSort {

    public static void main(String[] args) {
        System.out.println((-1) / 2);
    }

    public void bubbleSort(int[] arr){

        int temp;
        boolean flag = true;
        for(int i = 0; i < arr.length && flag; i++){

            flag = false;
            for(int j = arr.length; j > i; j--){

                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    flag = true;
                }
            }
        }
    }
}

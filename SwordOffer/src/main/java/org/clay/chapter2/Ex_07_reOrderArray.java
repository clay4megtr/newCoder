package org.clay.chapter2;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Ex_07_reOrderArray {


    /**
     * 如果需要保证稳定性，则时间复杂度为 O(N^2)
     * 插入排序：插入的原则是：当前数为奇数，且前一个数为偶数
     */
    public static void process2(int[] arr){

        for(int i = 1; i < arr.length; i++){
            for(int j = i-1; j >= 0 ; j--){
                if(arr[j+1] % 2 == 1 && arr[j] % 2 == 0){
                    swap(arr,j,j-1);
                }
            }
        }
    }

    /**
     * 如果不需要保证稳定性：则时间复杂度可以达到 O(N)
     */
    public static void process1(int[] arr){

        int odd = -1;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 == 1){
                swap(arr,i,++odd);
            }
        }
    }

    public static void swap(int[] arr,int i, int j){

        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void printArr(int[] arr){
        for(int t: arr){
            System.out.print(t + "  ");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,5,7,4,9,6};
        process1(arr);
        printArr(arr);

        System.out.println("========");
        process2(arr);
        printArr(arr);
    }
}

package org.clay.Book_Re_ArrayMatrix;

import java.util.Arrays;

/**
 * 无序数组，找到其中最小的k个数
 */
public class ArrayMinK {


    /**
     * 解法一：时间复杂度O(N*logK)
     */
    public static int[] getTopKByHeap(int[] arr,int k){

        int[] heapArray = new int[k];

        int heapSize = k;

        int index = 0;
        while(index < k){
            heapInsert(heapArray,arr[index],index++);
        }

        for(int i = k; i < arr.length; i++){
            if(arr[i] < heapArray[0]){  //大于大根堆的第一个节点，说明要更新
                heapArray[0] = arr[i];
                //然后重新更新大根堆
                heapify(heapArray,0,k);
            }
        }

        return heapArray;
    }

    public static void heapify(int[] arr,int index,int heapSize){

        int left = 2 * index + 1;

        while(left < heapSize){
            int largest = arr[left] > arr[index] ? left : index;
            if(left+1 < heapSize){
                largest = arr[left+1] > arr[largest] ? left + 1 : largest;
            }
            if(largest == index){
                break;
            }
            swap(arr,index,largest);
            index = largest;
            left = 2 * index + 1;
        }
    }

    public static void heapInsert(int[] arr,int value,int index){
        arr[index] = value;

        while(index != 0){
            int parent = (index-1) / 2;
            if(arr[index] > arr[parent]){
                swap(arr,index,parent);
            }
            index = parent;
        }
    }

    public static void swap(int[] arr,int a,int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }


    /**
     * 解法二：时间复杂度O(N)
     */
    public static int[] getTopKByBFPRT(){

        return null;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{7,4,5,6,1,2,3};
        int[] res = getTopKByHeap(arr,3);
        Arrays.stream(res).forEach(System.out::println);
    }
}
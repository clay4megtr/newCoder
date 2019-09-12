package org.clay.test3;


import org.clay.ArrayUtil;

public class HeapSort {


    public static void heapSort(int[] arr){

        for(int i = 0 ; i < arr.length; i++){
            heapInsert(arr,i);
        }

        ArrayUtil.swap(arr,0,arr.length-1);

        int heap_size = arr.length - 2;

        while(heap_size > 0){
            heapify(arr,heap_size,0);
            ArrayUtil.swap(arr,0,heap_size);
            heap_size--;
        }
    }

    public static void heapify(int[] arr,int heapSize,int cur){

        int left_index = 2 * cur + 1;

        while(left_index <= heapSize){
            int largest_index = arr[left_index] > arr[cur] ? left_index : cur;
            largest_index = (left_index + 1 <= heapSize && arr[left_index+1] > arr[largest_index]) ? left_index + 1 : largest_index;

            if(largest_index == cur){
                break;
            }

            ArrayUtil.swap(arr,cur,largest_index);

            cur = largest_index;
            left_index = 2 * cur + 1;
        }
    }



    public static void heapInsert(int[] arr,int cur){

        while(cur != 0){
            int parent = (cur-1) / 2;

            if(arr[cur] > arr[parent]){
                ArrayUtil.swap(arr,parent,cur);
            }

            cur = parent;
        }
    }


    public static void main(String[] args) {

        int[] arr = new int[]{3,1,2,4,5};
        HeapSort.heapSort(arr);

        ArrayUtil.printArr(arr);
    }
}

package org.clay.classFour_Re_1;

public class HeapSortRe {

    public static void heapSort(int[] arr){

        for(int i = 0; i < arr.length; i++){
            heapInsert(arr,i);
        }

        int heapSize = arr.length;
        swap(arr,0,--heapSize);

        while(heapSize > 0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }

    public static void heapify(int[] arr,int index, int heapSize){

        int left = 2 * index + 1;
        while(left < heapSize){
            int largest = (left+1) < heapSize && arr[left+1] > arr[left] ? left+1 : left;

            largest = arr[largest] < arr[index] ? index : largest;

            if (largest == index){
                break;
            }
            swap(arr,index,largest);
            index = largest;
            left = 2 * index + 1;
        }
    }

    public static void heapInsert(int[] arr, int index){

        while(arr[index] > arr[(index-1) / 2]){
            swap(arr,index,(index-1) / 2);
            index = (index-1) / 2;
        }
    }

    public static void swap(int[] arr,int a, int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
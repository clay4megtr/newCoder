package org.clay.classTwo;

import java.util.Arrays;

public class Code_03_HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);   // 建立大根堆
        }
        int heapSize = arr.length;//heapsize，开始时是数组长度，
        swap(arr, 0, --heapSize);//大根堆堆顶（数组最大元素）和最后一个位置的数字交换，此时最大元素的位置就排好了。堆顶的元素就是换上去的最后一个。
        while (heapSize > 0) {      //然后每次减小heapsize的大小，每次都
            heapify(arr, 0, heapSize);//heapify就是把第一个数字往下沉，重新构建大根堆的过程，但是此时要注意heapSize已经减1，因为上次最大的数字已经在最后一个位置了。
            swap(arr, 0, --heapSize);//大根堆构建完成，这个swap和上个swap的作用是一样的，都是把大根堆的最大值放到数组末尾。
        }
    }

    /**
     * index索引位置的值往下沉，重新构建大顶堆的过程。
     * heapify的过程，heapSize 就是标记当前处理的这个大根堆有几个节点
     * 0到 heapSize-1 这个区域是一个大根堆，此时index 标记的节点 变小了，此时要在 0到 heapSize-1 上重新把它变换成大根堆
     */
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = (2*index) + 1;//左孩子

        while (left < heapSize){
            int largest = left + 1 < heapSize && arr[left+1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;

            if(largest == index){//说明没换，说明变化的内个节点比左右孩子节点都要大；
                break;//说明已经是大顶堆了，直接退出循环即可。
            }
            //假如换了，就要继续往下沉。
            swap(arr,index,largest);//下沉
            index = largest;
            left = index * 2 + 1;//新的左孩子，每次都是用left（左孩子）去比较的，因为是往下沉的过程嘛，
        }
    }

    /**
     * 构建大根堆的过程
     * 也就是完全二叉树向上插入的过程
     */
    private static void heapInsert(int[] arr, int index) {
        while(arr[index] > arr[(index-1) / 2]){     //index(要插入的数)比它的父节点要大，就向上交换位置。
            swap(arr,index,(index-1) / 2);
            index = (index-1) / 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            heapSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        heapSort(arr);
        printArray(arr);
    }
}

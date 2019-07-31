package org.clay.test1;

//找第k小的数字
public class TopK {

    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static int[] partition(int[] arr, int begin, int end, int pivotValue) {

        int small = begin-1;
        int big = end + 1;
        int cur = begin;

        while(cur < big){
            if(arr[cur] < pivotValue){
                swap(arr,cur++,++small);
            }else if(arr[cur] > pivotValue){
                swap(arr,cur,--big);
            }else{
                cur++;
            }
        }

        return new int[]{small+1,big-1};
    }

    public static int getTopK(int[] arr, int begin, int end, int i){

        if (begin == end) {
            return arr[begin];
        }
        int pivot = arr[end];
        //partition过程，返回等于区域
        int[] pivotRange = partition(arr, begin, end, pivot);
        System.out.println(pivotRange[0] + "===" + pivotRange[1]);
        //命中直接返回，否则递归处理
        if (i >= pivotRange[0] && i <= pivotRange[1]) {
            return arr[i];
        } else if (i < pivotRange[0]) {
            return getTopK(arr, begin, pivotRange[0] - 1, i);
        } else {
            return getTopK(arr, pivotRange[1] + 1, end, i);
        }
    }

    public static void insertionSort(int[] arr, int begin, int end) {
        for (int i = begin + 1; i != end + 1; i++) {
            for (int j = i; j != begin; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    public static int getMedian(int[] arr, int begin, int end) {
        insertionSort(arr, begin, end);
        int sum = end + begin;
        int mid = (sum / 2) + (sum % 2);
        return arr[mid];
    }


    public static int medianOfMedians(int[] arr, int begin, int end) {
        int num = end - begin + 1;
        int offset = num % 5 == 0 ? 0 : 1;
        int[] mArr = new int[num / 5 + offset];  // num / 5 表示5个数一组，总共有多少组，这些组的中位数，
        for (int i = 0; i < mArr.length; i++) {
            int beginI = begin + i * 5;
            int endI = beginI + 4;
            mArr[i] = getMedian(arr, beginI, Math.min(end, endI));
        }
        return bfprt(mArr, 0, mArr.length - 1, mArr.length / 2);
    }


    //bfprt 算法本体，在begin和end范围内求第i小的数字；
    public static int bfprt(int[] arr, int begin, int end, int i) {
        if (begin == end) {
            return arr[begin];
        }
        //求划分值，5个值一组，求所有中位数的中位数，
        int pivot = medianOfMedians(arr, begin, end);
        //partition过程，返回等于区域
        int[] pivotRange = partition(arr, begin, end, pivot);
        //命中直接返回，否则递归处理
        if (i >= pivotRange[0] && i <= pivotRange[1]) {
            return arr[i];
        } else if (i < pivotRange[0]) {
            return bfprt(arr, begin, pivotRange[0] - 1, i);
        } else {
            return bfprt(arr, pivotRange[1] + 1, end, i);
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = { 6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9 };
        // sorted : { 1, 1, 1, 1, 2, 2, 2, 3, 3, 5, 5, 5, 6, 6, 6, 7, 9, 9, 9 }
        System.out.println(bfprt(arr,0,arr.length-1,4));
    }
}
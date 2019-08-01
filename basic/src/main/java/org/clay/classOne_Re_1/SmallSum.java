package org.clay.classOne_Re_1;

/**
 * 题意可以转化为求每个数字右边有多少个数字比它大，求最终的和
 */
public class SmallSum {

    public static Integer smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static Integer mergeSort(int[] arr,int left,int right){

        if(left == right){
            return 0;
        }

        int mid = (left + right) / 2;
        return mergeSort(arr,left,mid) + mergeSort(arr,mid+1,right) + merge(arr,left,mid,right);
    }

    //外排的过程
    private static Integer merge(int[] arr, int left, int mid, int right) {

        int[] help = new int[right-left+1];

        int left_index = left;
        int right_index = mid+1;
        int help_index = 0;
        int res = 0;

        while(left_index <= mid && right_index <= right){
            if(arr[left_index] < arr[right_index]){
                res += (right - right_index + 1) * arr[left_index];   //这里就是加速的过程，每次右边榨的时候，是分批榨的，而不是一个一个榨的，
                help[help_index++] = arr[left_index++];
            }else{
                help[help_index++] = arr[right_index++];
            }
        }

        /**
         * 为什么这两种情况不用榨小和？
         * 假设左边的数组取完了，说明已经没的可榨了，因为每次榨的就是左边的小和，
         * 假设右边的数组取完了，说明左边这个数组当前的这个数字已经是最大的了；右边已经没有数字比它大了，此时也不用榨了，
         */
        while(left_index <= mid){
            help[help_index++] = arr[left_index++];
        }

        while(right_index <= right){
            help[help_index++] = arr[right_index++];
        }

        help_index = 0;
        while(left <= right){
            arr[left++] = help[help_index++];
        }

        return res;
    }

    // for test
    public static int comparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
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
            if (smallSum(arr1) != comparator(arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}

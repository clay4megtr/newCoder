package org.clay.classOne;

/**
 * 每次找到 cur 在和右边的组合并的时候，右边的组中比当前cur大的数字的个数，
 * 也就是每次左边小组和右边小组合并的时候，榨出右边小组中比左边小组中大的数字的个数，
 * 每次合并都会榨取一遍，最终会把一个数字的小数个数都榨出来。
 * 具体可看图示。
 */
public class Code_12_SmallSum {

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int left, int mid, int right) {

        int[] help = new int[right - left + 1];
        int help_index = 0;
        int left_index = left;
        int right_index = mid + 1;
        int res = 0;

        while (left_index <= mid && right_index <= right) {
            if (arr[left_index] < arr[right_index]) {
                res += (right - right_index + 1) * arr[left_index];
                help[help_index++] = arr[left_index++];
            } else {
                help[help_index++] = arr[right_index++];
            }
        }

        while (left_index <= mid) {
            help[help_index++] = arr[left_index++];
        }
        while (right_index <= right) {
            help[help_index++] = arr[right_index++];
        }
        for(help_index = 0; help_index < help.length; help_index++){
            arr[left++] = help[help_index];
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

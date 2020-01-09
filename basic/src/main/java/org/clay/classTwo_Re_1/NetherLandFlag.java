package org.clay.classTwo_Re_1;

/**
 * 额外空间复杂度O(1): 意思就是不能使用额外的空间，不能再开辟一个数组，排好序再复制会原来的数组
 * 时间复杂度O(n)
 */
public class NetherLandFlag {

    //返回左右边界
    public static int[] partition(int[] arr,int left,int right, int target){

        int less = left - 1;
        int more = right + 1;
        int cur = left;

        while(cur < more){
            if(arr[cur] < target){
                swap(arr,cur++,++less);
            }else if(arr[cur] == target){
                cur++;
            }else{
                swap(arr,cur,--more);
            }
        }

        return new int[]{less+1,more-1};
    }

    public static void swap(int[] arr, int t1,int t2){
        arr[t1] = arr[t1] ^ arr[t2];
        arr[t2] = arr[t1] ^ arr[t2];
        arr[t1] = arr[t1] ^ arr[t2];
    }

    // for test
    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3);
        }
        return arr;
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

    public static void main(String[] args) {
        int[] test = generateArray();

        printArray(test);
        int[] res = partition(test, 0, test.length - 1, 1);
        printArray(test);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}

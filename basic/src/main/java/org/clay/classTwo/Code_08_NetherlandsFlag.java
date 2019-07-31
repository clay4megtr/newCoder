package org.clay.classTwo;

/**
 * 荷兰国旗问题
 * 小于num的数字放在左边，等于的放中间，大于的放在右边。
 */
public class Code_08_NetherlandsFlag {

    public static int[] partition(int[] arr, int L, int R, int num) {

        int less = L - 1;
        int more = R + 1;
        int cur = L;//指向当前数字的指针

        while (cur < more){
            if(arr[cur] < num){//说明应该在小于区域
                swap(arr,cur++,++less);   //和小于区域的下一个数字进行交换，cur也要跳下一个位置。
                //cur++ 先赋值，再自增
                //++less  先自增，再赋值
                //为什么换到小于区域之后，cur可以直接++呢？
                //因为换过来的数字肯定是等于num的呀!
                //就算是第一次换的时候，也是自己和自己换的呀！
            }else if(arr[cur] > num){
                swap(arr,cur,--more);   //和大于区域的前一个数字进行交换，
                // 这里为什么cur不要跳下一个位置呢？
                // 因为还要考察换过去的数字，是否也小于num。
                //从后面换到前面的数字可不一定是等于num的，可能还是大于num的。也可能是小于num的。
                //所以往大于区域扔过去一个数字之后，还要继续查看cur位置的数字。
            }else{
                cur++;
            }
        }
        //返回等于num的中间内一段。
        return new int[] { less + 1, more - 1 };
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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

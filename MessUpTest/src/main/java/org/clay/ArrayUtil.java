package org.clay;

public class ArrayUtil {


    public static int[] swap(int[] ints, int x, int y) {
        int temp = ints[x];
        ints[x] = ints[y];
        ints[y] = temp;
        return ints;
    }

    public static void printArr(int[] arr){

        Test1 test1 = new Test1();
        test1.getName();

        for(int num: arr){
            System.out.println(num);
        }
    }
}

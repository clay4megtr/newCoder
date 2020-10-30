package org.clay;

public class ArrayUtil {


    public static int[] swap(int[] ints, int x, int y) {
        int temp = ints[x];
        ints[x] = ints[y];
        ints[y] = temp;
        return ints;
    }

    public static void printArr(int[] arr){

        Test1 test2 = new Test1();
        test2.getName();

        Test1 test3 = new Test1();
        test3.getName();

        Test1 test4 = new Test1();
        test4.getName();

        for(int num: arr){
            System.out.println(num);
        }
    }
}

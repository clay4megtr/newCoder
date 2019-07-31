package org.clay.test1;

import java.util.HashMap;
import java.util.Map;

public class ZhuangShui {

    public static int getWater1(int[] arr) {
        if (arr.length == 0 || arr == null || arr.length == 1) {
            return 0;
        }

        int[] maxLeft = new int[arr.length];
        int[] maxRight = new int[arr.length];

        maxLeft[0] = arr[0];
        maxRight[arr.length - 1] = arr[arr.length - 1];

        for (int i = 1; i < arr.length; i++) {
            maxLeft[i] = arr[i] > maxLeft[i - 1] ? arr[i] : maxLeft[i - 1];
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            maxRight[i] = arr[i] > maxRight[i + 1] ? arr[i] : maxRight[i + 1];
        }

        int res = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            int max = maxLeft[i] > maxRight[i] ? maxRight[i] : maxLeft[i];
            int t = max - arr[i];
            res += t < 0 ? 0 : t;
        }

        return res;
    }

    public static int getWater2(int[] arr) {

        int maxLeft = arr[0];
        int maxRight = arr[arr.length-1];

        int L = 1;
        int R = arr.length-2;

        int res = 0;
        while(L <= R){
            if(maxRight > maxLeft){
                if(maxLeft - arr[L] < 0){
                    res += 0;
                    maxLeft = arr[L];
                }else{
                    res += maxLeft - arr[L];
                }
                L++;
            }else{
                if(maxRight - arr[R] < 0){
                    res += 0;
                    maxRight = arr[R];
                }else{
                    res += maxRight - arr[R];
                }
                R--;
            }
        }

        return res;
    }

    public static int[] generateRandomArray() {
        int[] arr = new int[(int) (Math.random() * 98) + 2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 200) + 2;
        }
        return arr;
    }

    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 4};
        int r1 = getWater2(arr);
        System.out.println(r1);
    }
}
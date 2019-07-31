package org.clay.test1;

public class MaxABSBetweenLeftAndRight {

    public static int getMax1(int[] arr){

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

        int res = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length; i++){
            int cha = Math.abs(maxLeft[i] - maxRight[i]);
            res = Math.max(res,cha);
        }

        return res;
    }

    public static int getMax2(int[] arr){

        int res = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++){
            max = Math.max(max,arr[i]);
        }
        int zero = arr[0];
        int nn = arr[arr.length-1];
        if(zero > nn){
            res = max - nn;
        }else{
            res = max - zero;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,5,2,1,0};
        System.out.println(getMax2(arr));
    }
}

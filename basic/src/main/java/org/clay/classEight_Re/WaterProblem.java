package org.clay.classEight_Re;

import java.util.Arrays;

public class WaterProblem {


    public static int getMushWater(int[] arr){

        int[] leftHelp = new int[arr.length];
        leftHelp[0] = arr[0];

        int[] rightHelp = new int[arr.length];
        rightHelp[arr.length-1] = arr[arr.length-1];

        for(int i = 1; i < arr.length; i++){
            if(arr[i] < leftHelp[i-1]){
                leftHelp[i] = leftHelp[i-1];
            }else{
                leftHelp[i] = arr[i];
            }
        }

        for(int i = arr.length-2; i >= 0; i--){
            if(arr[i] < rightHelp[i+1]){
                rightHelp[i] = rightHelp[i+1];
            }else{
                rightHelp[i] = arr[i];
            }
        }

        int sum = 0;

        for(int i = 1; i < arr.length-1; i++){
            if(arr[i] < leftHelp[i-1] && arr[i] < rightHelp[i+1]){
                sum += Math.min(leftHelp[i-1],rightHelp[i+1]) - arr[i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{3,1,2,4};
        System.out.println(getMushWater(arr));
    }
}
package org.clay.chapter2;

import org.clay.utils.Utils;

/**
 * 3.数组中重复的数字
 */
public class Ex_03_DumplateNumber {


    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public static boolean duplicate(int numbers[],int length,int [] duplication) {

        if(numbers == null || numbers.length == 0 || numbers.length == 1){
            return false;
        }

        int n = length;

        int i = 0;
        while(i < n){
            if(numbers[i] == i){
                i++;
            }else{
                if(numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }else{
                    swap(numbers,i,numbers[i]);
                }
            }
        }
        return false;
        asdad
    }

    public static void swap(int[] arr,int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
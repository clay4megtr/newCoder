package org.clay.classEight_Re;

/**
 * 打印全排列
 */
public class Print_All_Permutations {

    public static void printAllPermutations1(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0);
    }

    public static void process(char[] arr,int level){

        if(level == arr.length-1){
            System.out.println(arr);
            return;
        }

        for(int i = level; i < arr.length; i++){
            swap(arr,level,i);
            process(arr,level+1);
            swap(arr,level,i);
        }
    }


    public static void swap(char[] words,int a,int b){
        char t = words[a];
        words[a] = words[b];
        words[b] = t;
    }

    public static void main(String[] args) {
        String test1 = "abc";
        printAllPermutations1(test1);
    }
}

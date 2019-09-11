package org.clay.test3;

public class AllPaiLie {

    public static void printAllPaiLie(char[] strArr,int sum_level,int cur_level){

        if(cur_level == sum_level-1){
            System.out.println(String.valueOf(strArr));
        }else{
            for(int i = cur_level; i < strArr.length; i++){
                swap(strArr,cur_level,i);
                printAllPaiLie(strArr,sum_level,cur_level+1);
                swap(strArr,cur_level,i);
            }
        }

    }

    public static void swap(char[] arr,int i, int j){
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        String str = "abc";
        printAllPaiLie(str.toCharArray(),str.length(),0);
    }
}

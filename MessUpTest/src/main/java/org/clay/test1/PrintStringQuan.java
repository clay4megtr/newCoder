package org.clay.test1;

public class PrintStringQuan {


    public static void printAll(char[] str,int n){
        if(n == str.length-1){
            System.out.println(str);
        }else{
            for(int i = n; i < str.length; i++){
                swap(str,i,n);
                printAll(str,n+1);
                swap(str,i,n);
            }
        }
    }


    public static void swap(char[] arr,int i, int j){
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        printAll("abc".toCharArray(),0);
    }
}
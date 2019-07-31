package org.clay.test1;

public class RotateString {

    public static void getRes(String str,int k){

        String left = reverseStr(str.substring(0,str.length()-k).toCharArray());

        String right = reverseStr(str.substring(str.length()-k,str.length()).toCharArray());

        String res = reverseStr((left + right).toCharArray());
        System.out.println(res);
    }

    public static String reverseStr(char[] str){

        int l = 0;
        int r = str.length-1;

        while(l < r){
            char t = str[l];
            str[l] = str[r];
            str[r] = t;
            l++;
            r--;
        }
        return String.valueOf(str);
    }

    public static void main(String[] args) {

        getRes("abc",2);
    }
}

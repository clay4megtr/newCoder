package org.clay.Book_Re_String;

/**
 * 1. 单词间逆序
 * 2. 大小为size的左半区整体移到右半区，右半区整体移动到左半区
 */
public class ReverseString {


    public static String reverse(String str){

        char[] chars = str.toCharArray();

        int l = 0;
        int r = chars.length-1;

        while(l < r){
            swap(chars,l++,r--);
        }
        return String.valueOf(chars);
    }

    public static void swap(char[] chars,int i,int j){

        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

    public static void main(String[] args) {

        String str = "abcde";
        System.out.println(reverse(str));
    }
}

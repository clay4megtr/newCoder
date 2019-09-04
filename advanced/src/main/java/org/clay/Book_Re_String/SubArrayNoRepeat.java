package org.clay.Book_Re_String;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回一个字符串的最长无重复子串
 */
public class SubArrayNoRepeat {

    //O(N^2)
    public static int getMaxLength(String str){

        char[] chars = str.toCharArray();
        int res = 0;

        for(int i = 0; i < chars.length; i++){

            List<Character> userdChar = new ArrayList<>();
            for(int j = i; j < chars.length; j++){
                if(!userdChar.contains(chars[j])){
                    userdChar.add(chars[j]);
                }else{
                    break;
                }
            }
            res = Math.max(res,userdChar.size());
        }

        return res;
    }

    /**
     * 时间复杂度O(N)
     * 空间复杂度O(M),M为字符编码范围
     */
    public static int getMaxLengthDp(String str){

        if(str == null || str.length() == 0){
            return 0;
        }
        char[] chars = str.toCharArray();
        int[] map = new int[256];   //key为某个字符，value为这个字符最近一次出现的位置；
        for(int i = 0; i < 256; i++){
            map[i] = -1;
        }

        int len = 0;
        int pre = -1;   //pre表示在必须以str[i-1]字符结尾的情况下，最长无重复子串开始位置的前一个字符；那么pre+1就是最长无重复子串的开始位置
        int cur = 0;   //以当前字符结尾的情况下最长无重复子串的长度

        for(int i = 0; i != chars.length; i++){
            pre = Math.max(pre,map[chars[i]]); //pre大，说明pre位置在a位置(当前字符最近一次出现的位置)的右边，此时以当前字符结尾的最长无重复子串的长度就是pre+1位置到i位置,因为前一个字符的最长无重复子串的长度就是pre+1位置到i-1位置，当前位置不可能比前一个字符往前扩的更远；
                                            //a大，说明pre位置在a位置左边，此时以当前字符结尾的最长无重复子串的长度就是a+1到i位置；
            cur = i - pre;
            len = Math.max(len,cur);
            map[chars[i]] = i;
        }

        return len;
    }

    /**
     * 滑动窗口,比较好理解
     */
    public static int getMaxLengthWindow(String str){

        char[] chars = str.toCharArray();
        int[] map = new int[256];   //key为某个字符，value为这个字符最近一次出现的位置；
        for(int i = 0; i < 256; i++){
            map[i] = -1;
        }

        int len = 0;
        int front = 0;
        for(int back = 0; back < chars.length; back++){
            if(map[chars[back]] == -1){  //之前没出现过
                back++;
            }else{  //之前出现过
                front = map[chars[back]] + 1;
            }

            len = Math.max(back - front + 1,len);
            map[chars[back]] = back;
        }

        return len;
    }


    public static void main(String[] args) {

        String str = "pwwkew";
        System.out.println(getMaxLengthWindow(str));
    }
}
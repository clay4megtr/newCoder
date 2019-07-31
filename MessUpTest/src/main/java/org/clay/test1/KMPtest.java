package org.clay.test1;

public class KMPtest {

    public static int getIndexOf(String str1,String str2){

        char[] st1 = str1.toCharArray();
        char[] st2 = str2.toCharArray();

        int l1 = 0;
        int l2 = 0;

        int[] next = getNextArr(st2);

        while(l1 < st1.length && l2 < st2.length){
            if(st1[l1] == st2[l2]){
                l1++;
                l2++;
            }else{
                if(next[l2] == -1){  //此时l2已经指向第一个位置了，还是匹配不到，说明l1这个位置肯定匹配不到str2，所以 l1++
                    l1++;
                }else{
                    l2 = next[l2];
                }
            }
        }
        return l2 == st2.length ? l1-l2 : -1;  //l2指向str2的末尾了，说明str1中某个值匹配上了str2，此时l1-l2就是第一个匹配的字符
    }


    public static int[] getNextArr(char[] chars){

        int[] res = new int[chars.length];
        res[0] = -1;
        res[1] = 0;

        /*int pos = 2;  //the position we want
        int cn = 0;  //always the max suffix length location of last number

        while(pos < res.length){
            if(chars[pos-1] == chars[cn]){
                res[pos++] = ++cn;
            }else if(cn > 0){
                cn = res[cn];
            }else{
                res[pos++] = 0;
            }
        }*/

        for(int i = 2; i < res.length; i++){
            int last_len = res[i-1];
            if(chars[last_len] == chars[i-1]){
                res[i] = res[i-1] + 1;
            }else{
                while(last_len > 0){
                    last_len = res[last_len];//0,
                    if(chars[last_len] == chars[i-1]){
                        res[i] = last_len + 1;
                    }
                }
            }
        }
        return res;
    }

    public static void printArr(int[] arr){
        for(int t: arr){
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        String ss = "ababcababtk";
        printArr(getNextArr(ss.toCharArray()));
    }
}

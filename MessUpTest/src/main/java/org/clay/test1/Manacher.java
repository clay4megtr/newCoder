package org.clay.test1;

public class Manacher {

    public static char[] manacherString(String str){

        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for(int i = 0 ; i < res.length; i++){
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static int maxLcpsLength(String str){

        char[] charArr = manacherString(str);
        int[] pArr = new int[str.length()];  //回文半径数组

        int index = -1;  //c
        int pR = -1;   //回文右边界
        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < charArr.length; i++){  //以i位置为中心的回文串

            //i' location : 2 * index -i
            pArr[i] = pR > i ? Math.min(pArr[2 * index -i], pR -i) : 1;

            while(i + pArr[i] < charArr.length && i - pArr[i] > -1){
                if(charArr[i+pArr[i]] == charArr[i - pArr[i]]){
                    pArr[i]++;
                }else{
                    break;
                }
            }

            if(i+pArr[i] > pR){
                pR = i + pArr[i];
                index = i;
            }

            max = Math.max(max,pArr[i]);
        }

        return max -1 ;
    }
}

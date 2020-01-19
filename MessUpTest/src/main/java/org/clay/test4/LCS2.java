package org.clay.test4;

/**
 * 最长公共子串
 */
public class LCS2 {

    public static String generate(char[] str1, char[] str2){

        int[][] dp = getDp(str1,str2);

        int len = 0;
        int maxJ = 0;

        for(int i = 0; i < str2.length; i++){
            for(int j = 0; j < str1.length; j++){
                if(dp[i][j] > len){
                    len = dp[i][j];
                    maxJ = j;
                }
            }
        }

        char[] res = new char[len];

        while(len > 0){
            res[--len] = str1[maxJ--];
        }

        return String.valueOf(res);
    }


    public static int[][] getDp(char[] str1,char[] str2){

        int[][] dp = new int[str2.length][str1.length];

        for(int i = 0; i < str1.length; i++){
            if(str1[i] == str2[0]){
                dp[0][i] = 1;
            }
        }

        for(int i = 0; i < str2.length; i++){
            if(str2[i] == str1[0]){
                dp[i][0] = 1;
            }
        }

        for(int i = 1; i < str2.length; i++){
            for(int j = 1; j < str1.length; j++){
                if(str2[i] == str1[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }

        return dp;
    }

    public static void main(String[] args) {

        String str1 = "ABC1234567DEFG";
        String str2 = "HIJKL1234567MNOP";
        System.out.println(generate(str1.toCharArray(),str2.toCharArray()));
    }
}
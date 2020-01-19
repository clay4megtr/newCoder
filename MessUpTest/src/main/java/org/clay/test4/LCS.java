package org.clay.test4;

/**
 * 最长公共子序列 (不连续)
 */
public class LCS {


    public static String generate(char[] str1,char[] str2){

        int[][] dp = getDp(str1,str2);

        int i = str2.length-1;
        int j = str1.length-1;

        char[] res = new char[dp[i][j]];
        int index = res.length - 1;

        while(index >= 0){
            if(i > 0 && dp[i][j] == dp[i-1][j]){
                i--;
            }else if(j > 0 && dp[i][j] == dp[i][j-1]) {
                j--;
            }else{
                res[index--] = str2[i];
                i--;
                j--;
            }
        }

        return String.valueOf(res);
    }


    //获取dp数组，每个值代表对应位置str1和str2的最长公共子序列，dp[str1.length-1][str2.length-1]的值就是str1和str2的最长公共子序列的长度
    public static int[][] getDp(char[] str1,char[] str2){

        int[][] dp = new int[str2.length][str1.length];

        dp[0][0] = str1[0] == str2[0] ? 1 : 0;

        for(int i = 1; i < str1.length; i++){
            dp[0][i] = str1[i] == str2[0] ? 1 : dp[0][i-1];
        }

        for(int i = 1; i < str2.length; i++){
            dp[i][0] = str2[i] == str1[0] ? 1 : dp[i-1][0];
        }

        for(int i = 1; i < str2.length; i++){
            for(int j = 1; j < str1.length; j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if(str2[i] == str1[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }

        return dp;
    }

    public static void main(String[] args) {
        String str1 = "A1BC2D3EFGH45I6JK7LMN";
        String str2 = "12OPQ3RST4U5V6W7XYZ";
        System.out.println(generate(str1.toCharArray(),str2.toCharArray()));
    }
}

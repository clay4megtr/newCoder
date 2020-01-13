package org.clay.classEight_Re;

public class Knapsack {

    public static Integer process(int[] w, int[] v,int level,int cost,int bag){

        if(cost > bag){
            return Integer.MIN_VALUE;
        }

        if(level == w.length){
            return 0;  //这里总是理解不了，记住吧先
        }

        return Math.max(v[level] + process(w,v,level+1,cost+w[level],bag), process(w,v,level+1,cost,bag));
    }


    /**
     * 变量    i，  范围：    数组长度
     * 变量  cost， 范围：  w数组的sum和
     *
     */
    public static int process1(int[] w,int[] v,int bag){

        int[][] dp = new int[w.length+1][bag+1];

        for(int j = dp[0].length-1; j >= 0; j--){  //最后一行
            dp[dp.length-1][j] = 0;
        }

        for(int i = dp.length-2; i >= 0; i--){
            for(int j = 0; j < dp[0].length; j++){
                if(j+w[i] > bag){   //这里之所以要判断一下是否大于bag，是因为dp的列本应该是cost的sum的，
                    dp[i][j] = dp[i+1][j];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i+1][j+w[i]] + v[i]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] w = {7,3};
        int[] v = {9,5};
        int bag = 10;
        //System.out.println(process(w, v,0,0,bag));
        System.out.println(process1(w, v,bag));
    }
}

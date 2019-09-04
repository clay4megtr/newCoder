package org.clay.basic_class_02_Re;

/**
 * 换钱的方法数
 */
public class CoinsWay {

    public static int process(int[] arr,int index,int aim){

        int res = 0;
        if(arr == null || arr.length == 0){
            return 0;
        }
        if(index == arr.length){
            return aim == 0 ? 1 : 0;
        }

        for(int i = 0; arr[index] * i <= aim; i++){
            res += process(arr,index+1,aim - arr[index] * i);
        }

        return res;
    }

    /**
     * dp 版本
     * index变化范围: 0 ~ arr.length  ,  aim 变化范围: 0 ~ aim
     * 目标点 (0,aim)
     * basecase  index=arr.length 时
     */
    public static int dpProcess(int[] arr, int aim){

        int[][] dp = new int[arr.length+1][aim+1];

        for(int j = 0; j < dp[0].length; j++){ //填充最后一行的值，
            if(j == 0){
                dp[arr.length][j] = 1;
            }else{
                dp[arr.length][j] = 0;
            }
        }

        for(int i = dp.length-2; i >= 0; i--){ //从倒数第二行往上推
            for(int j = 0; j <= aim; j++){

                int num = 0;
                for(int k = 0; arr[i] * k <= j; k++){
                    num +=  dp[i+1][j - arr[i] * k];
                }
                dp[i][j] = num;
            }
        }

        return dp[0][aim];
    }

    public static void main(String[] args) {

        int[] arr = new int[]{5,10,25,1};
        int aim = 15;
        System.out.println(dpProcess(arr,aim));
    }
}
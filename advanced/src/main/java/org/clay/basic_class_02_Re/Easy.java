package org.clay.basic_class_02_Re;

/**
 * 机器人走路问题
 */
public class Easy {


    /**
     * @param start   当前所在位置
     * @param end     目标位置
     * @param size    数组大小
     * @param p       只能走p步
     * @return
     */
    public static int process(int start,int end, int size,int p){
        if(p == 0){
            return start == end ? 1: 0;
        }
        //p > 0
        if(start == 1){
            return process(start + 1,end,size,p-1);
        }

        if(start == size){
            return process(start - 1,end,size,p-1);
        }

        return process(start+1,end,size,p-1) + process(start-1,end,size,p-1);
    }

    /**
     * M的变化范围: 1 -
     */
    public static int walkDP(int N, int M, int P, int K){
        // 从递归的过程看：变量有 M 和 P
        int dp[][] = new int[N + 1][P + 1];
        // basecase：当在目标位置，还剩一步的时候
        dp[K][0] = 1;
        for(int j = 1; j <= P; j++){
            for(int i = 1; i <= N; i++){
                if(i - 1 < 1){
                    // 在第一个位置上
                    dp[i][j] = dp[i + 1][j - 1];
                }else if(i + 1 > N){
                    // 在最后一个位置上
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = dp[i + 1][j - 1] + dp[i - 1][j - 1];
                }
            }
        }
        return dp[M][P];
    }

    public static void main(String[] args) {

        System.out.println(process(2,3,4,3));
    }
}
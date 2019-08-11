package org.clay.basic_class_02_Re;

public class Easy {

    /**
     * @param N 多少个位置        不变
     * @param M 来到的位置
     * @param P 再走p步
     * @param K 最终停留在k位置    固定不变
     * @return 一共多少种走法
     */
    public static int walk(int N, int M, int P, int K){
        if(P == 0){
            // basecase
            return M == K ? 1 : 0;
        }
        // 开始位置和结束位置只能往一个方向走
        if(M == 1){
            return walk(N, M + 1, P - 1, K);
        }else if(M == N){
            return walk(N, M - 1, P - 1, K);
        }
        // 向左走和向右走两种选择
        return walk(N, M + 1, P - 1, K) + walk(N, M - 1, P - 1, K);
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

        System.out.println(walk(4,1,4,3));
    }
}
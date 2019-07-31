package org.clay.advanced_class_06;

public class Easy {

    /**
     * @param N 多少个位置        不变
     * @param M 来到的位置
     * @param P 再走p步
     * @param K 最终停留在k位置    固定不变
     * @return 一共多少种走法
     */
    public static int ways(int N, int M, int P, int K) {

        if (N < 2 || M < 1 || M > N || P < 0 || K < 1 || K > N) {
            return 0;
        }

        if (P == 0) {
            return M == K ? 1 : 0;
        }
        int res = 0;
        if (M == 1) {
            res += ways(N, M + 1, P - 1, K);
        } else if (M == N) {
            res += ways(N, M - 1, P - 1, K);
        } else {
            res += ways(N, M + 1, P - 1, K) + ways(N, M - 1, P - 1, K);
        }

        return res;
    }
}

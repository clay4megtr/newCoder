package org.clay.test3;

public class MachineWays {

    /**
     * @param N 总共n个位置
     * @param M 当前停留在m位置  变
     * @param P 需要走p步       变
     * @param K 最终停在K位置
     *
     * @return 走法数目
     */
    public static int ways(int N,int M,int P,int K){

        int res = 0;
        if(P == 0){
            return M == K ? 1 : 0;
        }

        if(M == 0){  //当前停留在0位置，
            res += ways(N,1,P-1,K);  //从1位置到K位置，走p-1步，有多少种走法
        }else if(M == N){
            res += ways(N,N-1,P-1,K); //从N-1位置到K位置，走p-1步，有多少种走法
        }else{
            res = ways(N,M+1,P-1,K) + ways(N,M-1,P-1,K); //从M+1位置到K位置走p-1步的走法 + 从M-1位置到K位置走p-1步的走法
        }

        return res;
    }


}

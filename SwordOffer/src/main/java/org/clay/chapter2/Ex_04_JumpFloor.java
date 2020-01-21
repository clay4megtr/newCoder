package org.clay.chapter2;

/**
 * 青蛙跳台阶，一次可以跳任意阶(>0)
 */
public class Ex_04_JumpFloor {

    //递归
    public static int process1(int n){

        if(n == 0){
            return 1;
        }

        int res = 0;
        for(int i = 1; i <= n; i++){
            //本次选择，选择跳i阶台阶，剩下的台阶交给子过程，每个选择就代表一个分解分支
            res += process1(n-i);
        }

        return res;
    }

    //dp
    //f(n) = f(n-1) + f(n-2) + f(n-3) + .... + f(0)
    public static int process2(int n){

        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                dp[i] += dp[j];
            }
        }

        return dp[n];
    }

    //dp 优化版, 之前的数字可以用一个 preSum 变量一直缓存着；
    public static int process3(int n){

        int[] dp = new int[n+1];
        dp[0] = 1;

        int preSum = dp[0];

        for(int i = 1; i < dp.length; i++){
            dp[i] = preSum;
            preSum += dp[i];
        }

        return dp[n];
    }


    public static void main(String[] args) {

        System.out.println(process1(4));
        System.out.println(process2(4));
        System.out.println(process3(4));
    }

}

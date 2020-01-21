package org.clay.chapter2;

/**
 * 斐波拉切数列
 */
public class Ex_03_Fibonacci {

    //递归版本
    public static int process(int n){
        if(n == 0 || n == 1){
            return n;
        }

        return process(n-1) + process(n-2);
    }

    //dp
    public static int process2(int n){

        if(n == 0 || n == 1){
            return n;
        }

        int n1 = 0,n2 = 1;
        int N = 2, res = 0;

        while(N++ < n){
            res = n1 + n2;
            n1 = n2;
            n2 = res;
        }

        return res;
    }
}

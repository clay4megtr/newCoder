package org.clay.chapter2;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Ex_05_RectCover {

    //递归：先竖着放一个或者先横着放两个，剩下的交给子过程处理
    public static int process1(int n){

        if(n == 1 || n == 2){
            return n;
        }

        return process1(n-1) + process1(n-2);
    }

    //dp: 斐波拉切
    public static int process2(int n){

        if(n == 1 || n == 2){
            return n;
        }

        int n1 = 1, n2 = 2;
        int N = 2, res = 0;

        while (N++ < n){
            res = n1 + n2;
            n1 = n2;
            n2 = res;
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println(process1(4));
        System.out.println(process2(4));
    }
}

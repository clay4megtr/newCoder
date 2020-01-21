package org.clay.chapter2;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Ex_06_NumberOf1 {

    //直接右移然后与1做 & 运算即可
    public static int process(int n){

        int count = 0;

        for(int i = 0; i < 32; i++){
            count += (n >> i) & 1;
        }

        return count;
    }
}

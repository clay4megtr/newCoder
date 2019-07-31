package org.clay.test2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 程序次序规则  1 -> 2    3 -> 4 -> 5
 * volatile规则    2 -> 3
 * 传递性规则    1 -> 5
 */
public class Demo {

    private int a;
    private volatile boolean flag;

    public void read(){
        a = 1;  //1R
        flag = true;//2
    }

    public void write(){
        if(flag){  //3
            int res = a+1;  //4
            System.out.println(res);  //5
        }
    }
}
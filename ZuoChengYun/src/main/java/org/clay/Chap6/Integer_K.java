package org.clay.Chap6;

/**
 * 求一个整数k的N次方
 * 如果两个数相乘并得到结果的时间复杂度是O(1)
 * 那么这里要求时间复杂度为O(logN)
 * @author clay
 */
public class Integer_K {

	public int getPower(int k, int N) {  
        long temp = k;  
        long res = 1;	//用来计算总和  
        long mm = 1000000007;  
        if(N == 1) return k;  
        if(N == 0) return 0;  
        for(;N>0;N>>=1){  
            if((N&1)!=0){//都为1 则为1 0000 0001  
                res = res * temp;  
            }  
            temp = (temp*temp) % mm;  
            res  = res % mm;  
        }  
       return  (int) res;  
    }  
}

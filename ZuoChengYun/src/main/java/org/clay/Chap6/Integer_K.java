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
        
        for(;N>0;N>>=1){  //N>>=1  就是把N除以2，即 右移一位， 
            if((N&1)!=0){ //右移一位然后和1比较，如果与的结果是1，说明此位置是1，也就说明该乘上对应的K的值
                res = res * temp;  
            }  
            temp = (temp*temp) % mm; //temp对应的值依次为k的1,2,4,8,16,32,64...次方， 
            res  = res % mm;  
        }  
       return  (int) res;  
    }  
}

package org.clay.Chap9;

/**
 * 分糖果，n棵相同的糖果，分给m个人，没人至少一颗，问有多少种分法
 * @author clay
 */
public class Distribution {

	/**
	 * 方法：插隔板，n块糖果，则有n-1个间隔
	 * 目标转换为n-1个空隙中选择m-1个插入隔板
	 */
	public int getWays(int n, int m){
		return zuhe(n-1, m-1);
	}
	
	/**
	 * @param m    总共有多少情况
	 * @param n	         选出多少种情况
	 */
	private int zuhe(int m, int n) {//n<=m
		int A = 1;
		int B = 1;
		int i = 0;
		while(i < n){		//第一个while循环求的就是   ------>   m! / (m-n)!
			A *= (m-i);
			i++;
		}
		while(n != 0){		//第二个while循环求的是=-------> 	  n!
			B *= n--;
		}
		return (A / B);
	}
}

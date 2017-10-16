package org.clay.Chap9;

/**
 * x * y的方格，左上角为起点，右下角为终点，只能向下或者向右，请问一共有多少种走法
 * 并且满足x+y <= 12
 * @author clay
 */
public class ManyWays {

	public int countWays(int x, int y){
		return zuhe(x+y-2, x-1);
	}

	/**
	 * @param m  x+y  总共有多少情况
	 * @param n	 y-1      选出多少种情况
	 */
	private int zuhe(int m, int n) {
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

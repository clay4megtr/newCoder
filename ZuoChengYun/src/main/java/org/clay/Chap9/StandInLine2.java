package org.clay.Chap9;

/**
 * n个人排成一排，要求甲和乙不相邻，并且甲和丙不相邻的排法是多少？
 * @author clay
 */
public class StandInLine2 {
	public int findWays(int n){
		int total = pailie(n);//总排列数
		int AB = 2*pailie(n-1); //甲和乙看成一个人，
		int AC = 2*pailie(n-1); //甲和丙看成一个人，
		int repeat = 2*pailie(n-2); //减去乙甲丙或丙甲乙出现的情况
		return total - AB - AC + repeat;
	}
	/**
	 * 排列，其实就是求阶乘的过程
	 */
	public int pailie(int m){
		int res = 1;
		while(m != 0){
			res *= m;
			m--;
		}
		return res;
	}
}

package org.clay.Chap9;

/**
 * n个人排队，编号依次为1到n，
 * 1.要求编号为a的人必须站在编号为b的人的左边，但是不要求相邻，有多少种排法，
 * 2.如果要求必须相邻，有多少种排法。
 * @author clay
 */
public class StandInLine {

	public int[] getWays(int n){
		int[] res = new int[2];
		res[0] = pailie(n)/2;	//总共的排法一共是n!种，其中A在B左边的情况和A在B右边的情况一定是平均此情况，所以除以2即可。
		res[1] = pailie(n-1);	//对于第二种情况，直接把a,b看成一个人即可。
		return res;
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

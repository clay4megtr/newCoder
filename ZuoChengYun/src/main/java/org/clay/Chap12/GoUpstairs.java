package org.clay.Chap12;

/**
 * n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。
 * 
 * @author clay
 */
public class GoUpstairs {

	/**
	 * 暴力搜索 走到i层台阶的方法数等于走到i-1层的方法数-走到i-2层的方法数
	 */
	public int countWays1(int n) {

		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return n;
		}
		return countWays1(n - 1) + countWays1(n - 2);
	}

	/**
	 * dp
	 */
	public int countWays2(int n) {
		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 2;
		for(int i = 2; i < n; i++){
			dp[i] = dp[i-1]+dp[i-2];
		}
		return dp[n-1];
	}
}

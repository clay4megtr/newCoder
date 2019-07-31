package org.clay.classSeven;

public class Code_09_Knapsack {

	public static int maxValue1(int[] c, int[] p, int bag) {
		return process1(c, p, 0, 0, bag);
	}

	/**
	 * 从两个数组的i位置开始，一直选到最后，能够获得的最大收益
	 * @return
	 */
	public static int process1(int[] c, int[] p, int i, int cost, int bag) {
		if (cost > bag) {  //减枝的策略，递归的过程中，如果之前的选择已经大于了bag，就不用继续往下选了；
			return Integer.MIN_VALUE;
		}
		if (i == c.length) {
			return 0; //返回0是因为到最后了，之前的选择不会影响后面的结果，最后没的可选了，返回的收益肯定是0；
		}
		return Math.max(process1(c, p, i + 1, cost, bag), p[i] + process1(c, p, i + 1, cost + c[i], bag));
	}

	public static int maxValue2(int[] c, int[] p, int bag) {
		int[][] dp = new int[c.length + 1][bag + 1];
		for (int i = c.length - 1; i >= 0; i--) {
			for (int j = bag; j >= 0; j--) {
				dp[i][j] = dp[i + 1][j];
				if (j + c[i] <= bag) {
					dp[i][j] = Math.max(dp[i][j], p[i] + dp[i + 1][j + c[i]]);
				}
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		int[] c = { 1, 2, 3,4,5};
		int[] p = { 1, 2, 3,4,5};
		int bag = 7;
		System.out.println(maxValue1(c, p, bag));
		//System.out.println(maxValue2(c, p, bag));
	}
}

package org.clay.advanced_class_07;

/**
 * 求最长公共子序列
 * 时间复杂度: O(M*N)
 * 空间复杂度: O(M*N)
 */
public class Code_03_LCSubsequence {

	public static String lcse(String str1, String str2) {
		if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
			return "";
		}
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		int[][] dp = getdp(chs1, chs2);

		/**
		 * 从dp数组求得最终的最长子序列的过程
		 * 从dp矩阵的右下角开始，有三种移动方式，向上，向左，向左上，
		 * 1>如果dp[i][j]大于dp[i-1][j]和dp[i][j-1],说明之前在计算dp[i][j]的时候，一定是选择了决策dp[i-1][j-1]+1，此时可以确定str1[i]=str2[j]，并且这个字符一定属于最长公共子序列，
		 * 把这个字符放进res，然后向左上方移动
		 * 2>如果dp[i][j]等于dp[i-1][j]，说明之前在计算dp[i][j]的时候，dp[i-1][j-1]+1这个决策不是必须的，向上方移动即可
		 * 2>如果dp[i][j]等于dp[i][j-1]，同上，此时向左移动，
		 * 3>如果dp[i][j]同时等于dp[i-1][j]和dp[i][j-1]，向上还是向左无所谓，反正不会错过必须选择的字符，
		 * 也就是说，通过dp求解最长公共子序列的过程就是还原出当时如何求解dp的过程，来自哪个策略，就朝哪个方向移动，
		 *
		 */
		int m = chs1.length - 1;
		int n = chs2.length - 1;
		char[] res = new char[dp[m][n]];
		int index = res.length - 1;
		while (index >= 0) {
			if (n > 0 && dp[m][n] == dp[m][n - 1]) {
				n--;
			} else if (m > 0 && dp[m][n] == dp[m - 1][n]) {
				m--;
			} else {
				res[index--] = chs1[m];
				m--;
				n--;
			}
		}
		return String.valueOf(res);
	}

	/**
	 * 求dp数组，每个值代表对应位置str1和str2的最长公共子序列，dp[str1.length-1][str2.length-1]的值就是str1和str2的最长公共子序列的长度
	 */
	public static int[][] getdp(char[] str1, char[] str2) {
		int[][] dp = new int[str1.length][str2.length];
		dp[0][0] = str1[0] == str2[0] ? 1 : 0;
		for (int i = 1; i < str1.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);   //补dp矩阵的第一列
		}
		for (int j = 1; j < str2.length; j++) {
			dp[0][j] = Math.max(dp[0][j - 1], str1[0] == str2[j] ? 1 : 0);   //补dp矩阵的第一行，
		}
		//然后从dp[1][1]开始，从左到右，从上到下，补充dp矩阵，
		for (int i = 1; i < str1.length; i++) {
			for (int j = 1; j < str2.length; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);  //前一行的数据和前一列的数据，取最大值
				if (str1[i] == str2[j]) {  //如果i==j，说明此时公共子序列的长度应该+1;
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
				}
			}
		}
		return dp;
	}

	public static void main(String[] args) {
		String str1 = "A1BC2D3EFGH45I6JK7LMN";
		String str2 = "12OPQ3RST4U5V6W7XYZ";
		System.out.println(lcse(str1, str2));
	}
}
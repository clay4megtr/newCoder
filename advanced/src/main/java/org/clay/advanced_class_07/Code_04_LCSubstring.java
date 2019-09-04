package org.clay.advanced_class_07;

/**
 * 最长公共子串
 * 时间复杂度: O(M*N)
 * 空间复杂度: O(M*N)
 *
 * 优化之后：空间复杂度 O(1)
 */
public class Code_04_LCSubstring {

	public static String lcst1(String str1, String str2) {
		if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
			return "";
		}
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		int[][] dp = getdp(chs1, chs2);

		/**
		 * 从dp数组求最长公共子串的过程，这个过程非常简单，找到dp矩阵中的最大值，直接往前扩相应的距离即可；
		 */
		int end = 0;
		int max = 0;
		for (int i = 0; i < chs1.length; i++) {
			for (int j = 0; j < chs2.length; j++) {
				if (dp[i][j] > max) {
					end = i;
					max = dp[i][j];
				}
			}
		}
		return str1.substring(end - max + 1, end + 1);
	}

	/**
	 * 生成dp数组
	 * dp[i][j]的含义是，在必须把str1[i]和str2[j]当做公共子串最后一个字符的情况下，公共子串最长能有多长，
	 */
	public static int[][] getdp(char[] str1, char[] str2) {
		int[][] dp = new int[str1.length][str2.length];
		for (int i = 0; i < str1.length; i++) {  //补充第一列，
			if (str1[i] == str2[0]) {
				dp[i][0] = 1;
			}
		}
		for (int j = 1; j < str2.length; j++) {  //补充第一行
			if (str1[0] == str2[j]) {
				dp[0][j] = 1;
			}
		}
		/**
		 * 其他位置按照从左到右，从上到下，依次计算，
		 * >如果str1[i] != str2[j]，说明在必须把str1[i]和str[j]当做公共子串最后一个字符是不可能的，所以dp[i][j] == 0;
		 * >如果str1[i] == str2[j]，说明str1[i]和str[j]可以作为公共子串的的最后一个字符，重点是此时从这个字符向左能扩多大的长度呢？
		 *  其实就是dp[i-1][j-1]的值，所以dp[i][j] = dp[i-1][j-1]+1;
		 */
		for (int i = 1; i < str1.length; i++) {
			for (int j = 1; j < str2.length; j++) {
				if (str1[i] == str2[j]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
			}
		}
		return dp;
	}

	/**
	 * 优化思路：
	 * 其实最终要求的只是一个 最长公共子串的最大长度 和 产生这个最大长度的index值（i和j都可）,
	 * 通过这两个值就可以求出最终的最长公共子串，因为子串是连续的，通过这两个值，再做一些简单的字符串截取就可以得到结果了；
	 *
	 * 计算每一个dp[i][j]的时候，只需要dp[i-1][j-1]的值，所以按照斜线方向来计算所有的值，只需要一个变量就可以计算出所有位置的值；
	 */
	public static String lcst2(String str1, String str2) {
		if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
			return "";
		}
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		int row = 0;  //斜线位置开始的行，
		int col = chs2.length - 1; //斜线位置开始的列， 从右上角开始，
		int max = 0;  //记录最大长度，
		int end = 0;  //最大长度更新时，记录子串的结束位置；
		while (row < chs1.length) {
			int i = row;
			int j = col;
			int len = 0; //len表示左上方位置的值，

			//从(i,j)开始，向右下方遍历；从左上到右下，遍历一条线；
			while (i < chs1.length && j < chs2.length) {
				if (chs1[i] != chs2[j]) {
					len = 0;
				} else {
					len++;
				}
				if (len > max) {
					end = i;
					max = len;
				}
				i++;
				j++;
			}
			if (col > 0) {
				col--;
			} else {
				row++;
			}
		}
		return str1.substring(end - max + 1, end + 1);
	}

	public static void main(String[] args) {
		String str1 = "ABC1234567DEFG";
		String str2 = "HIJKL1234567MNOP";
		System.out.println(lcst1(str1, str2));
		System.out.println(lcst2(str1, str2));
	}
}
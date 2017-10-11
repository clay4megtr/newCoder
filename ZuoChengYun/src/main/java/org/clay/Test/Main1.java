package org.clay.Test;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		String sourceStr = reader.nextLine();
		
		if(sourceStr == null || sourceStr.length() == 0){
			return;
		}
		if(sourceStr == " " || sourceStr.charAt(sourceStr.length()-1)+"" == " "){
			return;
		}
		String reverseStr = sentenceReverse(sourceStr);
//		String[] sourceSplit = sourceStr.split(" ");
//		String[] reverseSplit = reverse.split(" ");  //长度相等
		//最长子序列- 动态规划- 每个子串求最长公共子序列
		int res = 0;
		res = findLCS(sourceStr, reverseStr);
		System.out.println(res);
	}

	public static int findLCS(String A, String B) {
		int n = A.length();
		int m = B.length();
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();
		int[][] dp = new int[n][m];
		for (int i = 0; i < n; i++) {// 第一列
			if (a[i] == b[0]) {
				dp[i][0] = 1;
				for (int j = i + 1; j < n; j++) {
					dp[j][0] = 1;
				}
				break;
			}
		}

		for (int i = 0; i < m; i++) {// 第一行
			if (a[0] == b[i]) {
				dp[0][i] = 1;
				for (int j = i + 1; j < m; j++) {
					dp[0][j] = 1;
				}
				break;
			}
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (a[i] == b[j]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
			}
		}
		return dp[n - 1][m - 1];
	}
	
	//反转字符串
	public static String reverse(String source) {

		char[] array = source.toCharArray();

		int n = source.length() - 1;

		int halfLength = n / 2;

		for (int i = 0; i <= halfLength; i++) {

			char temp = array[i];
			array[i] = array[n - i];
			array[n - i] = temp;
		}
		return new String(array);
	}

	//句子反转
	public static String sentenceReverse(String snetence) {

		StringBuilder builder = new StringBuilder();

		String reverseSentence = reverse(snetence);

		String[] split = reverseSentence.split(" ");

		for (int i = 0; i < split.length; i++) {

			builder.append(reverse(split[i]) + " ");
		}

		return builder.toString();
	}
}

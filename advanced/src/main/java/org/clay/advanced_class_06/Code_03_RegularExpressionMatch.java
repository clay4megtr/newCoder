package org.clay.advanced_class_06;

public class Code_03_RegularExpressionMatch {

	public static boolean isValid(char[] s, char[] e) {
		for (int i = 0; i < s.length; i++) {
			if (s[i] == '*' || s[i] == '.') {
				return false;
			}
		}
		for (int i = 0; i < e.length; i++) {
			if (e[i] == '*' && (i == 0 || e[i - 1] == '*')) {
				return false;
			}
		}
		return true;
	}

	public static boolean isMatch(String str, String exp) {
		if (str == null || exp == null) {
			return false;
		}
		char[] s = str.toCharArray();
		char[] e = exp.toCharArray();
		return isValid(s, e) ? process(s, e, 0, 0) : false;
	}

	/**
	 * 暴力递归
	 * str[i,len(i)]这个字符串能不能被exp[j,len(exp)] 这个字符串，匹配出来
	 */
	public static boolean process(char[] str, char[] exp, int i, int j) {
		if (j == exp.length) { //j到了终止位置，后面什么都没有了，此时i及其之后的位置只能配 "" 空串了，
			return i == str.length; //如果exp耗尽了，那么只有str也耗尽了，才能返回true；
		}
		//j 上面还有字符，考察 j+1 的情况，也就是第一种情况
		if (j + 1 == exp.length || exp[j + 1] != '*') {
			//j上面还有字符，此时如果i已经到末尾了，直接返回false
			return i != str.length && (exp[j] == str[i] || exp[j] == '.')
					&& process(str, exp, i + 1, j + 1);
		}
		//exp[j + 1] 不仅有字符，而且还是 *
		//当i没到最后的情况下，而且i和j的字符还能配上，就走接下来的每一条路
		while (i != str.length && (exp[j] == str[i] || exp[j] == '.')) {
			if (process(str, exp, i, j + 2)) {
				return true;
			}
			i++;  // i++
		}
		return process(str, exp, i, j + 2);
	}

	public static boolean isMatchDP(String str, String exp) {
		if (str == null || exp == null) {
			return false;
		}
		char[] s = str.toCharArray();
		char[] e = exp.toCharArray();
		if (!isValid(s, e)) {
			return false;
		}
		boolean[][] dp = initDPMap(s, e); //填好最后两列和最后一行；
		for (int i = s.length - 1; i > -1; i--) {
			for (int j = e.length - 2; j > -1; j--) {
				if (e[j + 1] != '*') {
					dp[i][j] = (s[i] == e[j] || e[j] == '.')
							&& dp[i + 1][j + 1];
				} else {
					int si = i;
					while (si != s.length && (s[si] == e[j] || e[j] == '.')) {
						if (dp[si][j + 2]) {
							dp[i][j] = true;
							break;
						}
						si++;
					}
					if (dp[i][j] != true) {
						dp[i][j] = dp[si][j + 2];
					}
				}
			}
		}
		return dp[0][0];
	}

	public static boolean[][] initDPMap(char[] s, char[] e) {
		int slen = s.length;
		int elen = e.length;
		boolean[][] dp = new boolean[slen + 1][elen + 1];
		dp[slen][elen] = true;
		for (int j = elen - 2; j > -1; j = j - 2) {
			if (e[j] != '*' && e[j + 1] == '*') {
				dp[slen][j] = true;
			} else {
				break;
			}
		}
		if (slen > 0 && elen > 0) {
			if ((e[elen - 1] == '.' || s[slen - 1] == e[elen - 1])) {
				dp[slen - 1][elen - 1] = true;
			}
		}
		return dp;
	}

	public static void main(String[] args) {
		String str = "abcccdefg";
		String exp = "ab.*d.*e.*";
		System.out.println(isMatch(str, exp));
		System.out.println(isMatchDP(str, exp));
	}
}
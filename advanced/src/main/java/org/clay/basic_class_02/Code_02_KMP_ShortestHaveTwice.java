package org.clay.basic_class_02;

public class Code_02_KMP_ShortestHaveTwice {

	public static String answer(String str) {
		if (str == null || str.length() == 0) {
			return "";
		}
		char[] chas = str.toCharArray();
		if (chas.length == 1) {
			return str + str;
		}
		if (chas.length == 2) {
			return chas[0] == chas[1] ? (str + String.valueOf(chas[0])) : (str + str);
		}
		int endNext = endNextLength(chas);
		return str + str.substring(endNext);
	}

	/**
	 * @param chas 原串
	 * @return  多出来的内一位对应的最长后缀长度
	 */
	public static int endNextLength(char[] chas) {
		int[] next = new int[chas.length + 1]; //长度+1，因为要求最后一位后面的位置的最长后缀长度
		next[0] = -1;
		next[1] = 0;
		int pos = 2; 	//求哪个位置的最长后缀；
		int cn = 0;		// 跳到的位置，也就是第一个最长后缀的下一个位置；
		while (pos < next.length) {
			if (chas[pos - 1] == chas[cn]) {
				next[pos++] = ++cn;
			} else if (cn > 0) {
				cn = next[cn];
			} else {
				next[pos++] = 0;
			}
		}
		return next[next.length - 1];
	}

	public static void main(String[] args) {
		String test1 = "a";
		System.out.println(answer(test1));

		String test2 = "aa";
		System.out.println(answer(test2));

		String test3 = "ab";
		System.out.println(answer(test3));

		String test4 = "abcdabcd";
		System.out.println(answer(test4));

		String test5 = "abracadabra";
		System.out.println(answer(test5));
	}
}

package org.clay.basic_class_02;

public class Code_01_KMP {

	public static int getIndexOf(String s, String m) {
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int si = 0;    // 指向str1
		int mi = 0;    // 指向str2
		int[] next = getNextArray(ms);
		//注意整个过程中，si是一直往后走的，而 且每次判断si开始是否包含str2的时候，并没有每次遍历str2，
		//而只是在ss[si] != ms[mi]的时候，进行跳数组的操作，相等的时候，是没有尝试匹配的，
		//原因查看当时的解析即可；
		while (si < ss.length && mi < ms.length) { //si指向str1，mi指向str2
			if (ss[si] == ms[mi]) {  //相等，同时++
				si++;
				mi++;
			} else{
				if (next[mi] == -1) {   //next 数组中0位置我们定为-1，因为0位置前面不可能有最长后缀
					//mi往前跳的时候，是根据next数组中对应位置的值来跳的，=-1，说明没得跳了，已经指向str2的0位置了；
					//mi已经指向第一个字符了，还是配不上，说明si之后不可能匹配到整个str2，si++，检查下一个字符是否能够匹配
					si++;
				} else {
					mi = next[mi];   // 能往前就往前跳; 其实这就是str2往后推的逻辑概念
				}
			}
		}
		return mi == ms.length ? si - mi : -1;
	}

	/**
	 * 求解next数组
	 */
	public static int[] getNextArray(char[] ms) {
		if (ms.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2; //来到的位置
		int cn = 0;   // 跳到的位置
		while (pos < next.length) {  // pos不断增加，每一个位置都要求出来，
			if (ms[pos - 1] == ms[cn]) {  //如果当前跳到的位置和前一个字符是一致的，i位置的最长后缀长度就是i-1位置最长后缀长度+1
				next[pos++] = ++cn;  //cn其实就是第一个最长后缀的下一个字符，所以跳到cn就表示第一个最长后缀的长度就是cn，那么pos位置的最长后缀长度就是:cn+1
			} else if (cn > 0) {  //不相等，就再往前跳
				cn = next[cn];  //next[cn]就表示cn位置的最长后缀长度，也就是跳到第一个最长后缀的下一个字符，
			} else {
				next[pos++] = 0; //cn <= 0，说明跳到头了；pos位置的最长后缀长度就是0；
			}
		}
		return next;
	}

	public static void main(String[] args) {
		String str = "abcabcababaccc";
		String match = "ababa";
		System.out.println(getIndexOf(str, match));
	}
}

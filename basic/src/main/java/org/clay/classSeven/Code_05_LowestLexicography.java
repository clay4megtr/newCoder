package org.clay.classSeven;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 字符串：按照字典序排序
 * 证明非常之难！！！！！！！！！！！！！！！
 */
public class Code_05_LowestLexicography {

    /**
     * 按照自定义的比较器进行比较
     */
	public static class MyComparator implements Comparator<String> {
		@Override
		public int compare(String a, String b) {
			return (a + b).compareTo(b + a);
		}
	}

	public static String lowestString(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		Arrays.sort(strs, new MyComparator());
		String res = "";
		for (int i = 0; i < strs.length; i++) {
			res += strs[i];
		}
		return res;
	}

	public static void main(String[] args) {
		String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
		System.out.println(lowestString(strs1));

		String[] strs2 = { "ba", "b" };
		System.out.println(lowestString(strs2));
	}
}

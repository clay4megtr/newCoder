package org.clay.Chap3;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回str的最长无重复子串的长度
 *  abcd 4
 *  abcb 3
 * @author clay
 */
public class MaxNoDumpSubstr {

	/**
	 * 时间复杂度O(n) 空间复杂度O(n)
	 */
	public int maxNoDumpSubstr(String A, int n) {
		// charPosition统计A中每种字符之前出现的位置
		Map<Character, Integer> charPosition = new HashMap<>();
		// preArr代表以s[i-1]结尾的情况下，最长无重复子串的长度
		int[] preArr = new int[A.length()];

		char[] str2charArr = A.toCharArray();

		// 从头到尾遍历str2charArr，统计出以每个字符为当前位置的向前最长无重复子串的长度
		for (int i = 0; i < A.length(); i++) {
			// 获取上次出现的位置
			Integer lastPosOfChar = charPosition.get(str2charArr[i]);
			if (lastPosOfChar == null) { // 当前字符第一次出现
				// 更新最长无重复子串的长度
				preArr[i] = i == 0 ? 1 : preArr[i - 1] + 1;
				// 记录当前字符出现的位置
				charPosition.put(str2charArr[i], i);
			} else {
				// 当前字符不是第一次出现(既然不是第一次出现，那也不是在第一个位置),也就是之前出现过该字符
				// 获取前一个字符最长无重复子串的长度
				int aPos = lastPosOfChar + 1; // 这个字符上一次出现的位置后面的第一个位置。
				int unRepeatLen = preArr[i - 1]; // 这个字符前面的一个字符向左的最长无重复子串的长度
				int bPos = i - unRepeatLen; // i位置减去长度就是前面的一个字符出现的位置

				if (aPos >= bPos) {
					// 当前位置的最长无重复子串长度
					preArr[i] = i - aPos + 1;
				} else {
					// 当前位置的最长无重复子串长度
					preArr[i] = i - bPos + 1;
				}
				// 跟新当前字符出现的位置
				charPosition.put(str2charArr[i], i);
			}
		}
		// 遍历preArr,最大值即为所求
		int max = preArr[0];
		for (int i : preArr) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}

	/**
	 * 时间复杂度O(n) 空间复杂度O(n)
	 */
	public int maxNoDumpSubstr2(String A, int n) {

		Map<Character, Integer> hash = new HashMap<>();// 保存每个字符出现的位置
		int[] preArr = new int[A.length()]; 		   // 保存每一个字符的向左的最长无重复子串的长度。

		char[] charArray = A.toCharArray();

		for (int i = 0; i < charArray.length; i++) {

			Integer lastPos = hash.get(charArray[i]);// 当前字符上一次出现的位置

			if (lastPos == null) { // 第一次出现
				preArr[i] = i == 0 ? 1 : preArr[i - 1] + 1;
				hash.put(charArray[i], i);
			} else {
				// 不是第一次出现
				int aPos = lastPos + 1;
				int bPos = i - preArr[i - 1];

				if (aPos >= bPos) {
					// 当前位置的最长无重复子串长度
					preArr[i] = i - aPos + 1;
				} else {
					// 当前位置的最长无重复子串长度
					preArr[i] = i - bPos + 1;
				}
				// 跟新当前字符出现的位置
				hash.put(charArray[i], i);
			}
		}
		// 遍历preArr,最大值即为所求
		int max = preArr[0];
		for (int i : preArr) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		MaxNoDumpSubstr nnds = new MaxNoDumpSubstr();
		System.out.println(nnds.maxNoDumpSubstr2("abcb", 4));
	}
}

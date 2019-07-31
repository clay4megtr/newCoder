package org.clay.basic_class_02;

public class Code_04_Manacher {

	//给原串加上特殊字符#
	public static char[] manacherString(String str) {
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length() * 2 + 1];
		int index = 0;
		for (int i = 0; i != res.length; i++) {
			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}

	public static int maxLcpsLength(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] charArr = manacherString(str);
		int[] pArr = new int[charArr.length];  //回文半径数组
		int index = -1; //C 位置
		int pR = -1;  //回文右边界
		int max = Integer.MIN_VALUE;
		for (int i = 0; i != charArr.length; i++) {  //以i位置为中心的回文串
			//2 * index - i就是i'的位置，pArr[2 * index - i]：i位置的回文半径，
			// i > pR,说明是情况1，i位置不在回文右边界之前，i位置的回文半径就先置为1，下面在继续往外扩；
			//如果是情况2，i'位置的回文半径在L和R内部，那么pArr[2 * index - i] < pR - i，那么i位置的回文半径就是i'位置的回文半径
			//如果是情况3，i'位置的回文半径在L外部，那么pArr[2 * index - i] > pR - i,那么i位置的回文半径就是i到R的长度；
			//pR > i:情况2，3，4； pR < i:情况1，
			pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;

			//不管是哪种情况，都往外扩一下，i + pArr[i] < charArr.length 左边不越界，i - pArr[i] > -1 右边不越界
			//当然这里可以写成4个if else，但是代码会很长；所以这里直接扩，只是情况2，3扩一下会直接停；
			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]]) //扩出来的两个值相等，
					pArr[i]++;  // 回文半径 ++
				else {
					break;
				}
			}
			if (i + pArr[i] > pR) {  //扩出来的区域超过了R，
				pR = i + pArr[i]; 	//新的回文右边界
				index = i;			// C位置；
			}
			max = Math.max(max, pArr[i]); // 记录全局最大值
		}
		return max - 1;
	}

	public static void main(String[] args) {
		String str1 = "abc1234321ab";
		System.out.println(maxLcpsLength(str1));
	}
}

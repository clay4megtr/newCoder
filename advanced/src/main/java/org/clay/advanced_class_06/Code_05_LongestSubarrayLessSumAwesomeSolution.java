package org.clay.advanced_class_06;

import java.util.HashMap;

public class Code_05_LongestSubarrayLessSumAwesomeSolution {

	public static int maxLengthAwesome(int[] arr, int aim) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int[] sums = new int[arr.length];
		int[] ends = new int[arr.length];

		sums[arr.length - 1] = arr[arr.length - 1];
		ends[arr.length - 1] = arr.length - 1;

		//生成两个信息
		for (int i = arr.length - 2; i >= 0; i--) {
			if (sums[i + 1] < 0) {
				sums[i] = arr[i] + sums[i + 1];  //负数
				ends[i] = ends[i+1];  //右边前一个到达的右边界
			} else {
				sums[i] = arr[i];
				ends[i] = i;
			}
		}

		// 利用两个信息做计算,
		int R = 0;  //右边界
		int sum = 0;   //start 到 R 的累加和
		int len = 0;
		for (int start = 0; start < arr.length; start++) {
			while (R < arr.length && sum + sums[R] <= aim) {  //越界了或者累加和超过aim了。
				sum += sums[R];
				R = ends[R] + 1;
			}
			sum -= R > start ? arr[start] : 0;  // R > start 说明窗口有值，
			len = Math.max(len, R - start);  //更新长度
			R = Math.max(R, start + 1);  //需要考虑一个数都扩不动的情况；此时R也需要向右扩，否则R就不动了；
		}
		return len;
	}

	public static int maxLength(int[] arr, int k) {
		int[] h = new int[arr.length + 1];
		int sum = 0;
		h[0] = sum;
		for (int i = 0; i != arr.length; i++) {
			sum += arr[i];
			h[i + 1] = Math.max(sum, h[i]);
		}
		sum = 0;
		int res = 0;
		int pre = 0;
		int len = 0;
		for (int i = 0; i != arr.length; i++) {
			sum += arr[i];
			pre = getLessIndex(h, sum - k);
			len = pre == -1 ? 0 : i - pre + 1;
			res = Math.max(res, len);
		}
		return res;
	}

	public static int getLessIndex(int[] arr, int num) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		int res = -1;
		while (low <= high) {
			mid = (low + high) / 2;
			if (arr[mid] >= num) {
				res = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return res;
	}

	// for test
	public static int[] generateRandomArray(int len, int maxValue) {
		int[] res = new int[len];
		for (int i = 0; i != res.length; i++) {
			res[i] = (int) (Math.random() * maxValue) - (maxValue / 3);
		}
		return res;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 1000000; i++) {
			int[] arr = generateRandomArray(10, 20);
			int k = (int) (Math.random() * 20) - 5;
			if (maxLengthAwesome(arr, k) != maxLength(arr, k)) {
				System.out.println("oops!");
			}
		}
	}
}
package org.clay.advanced_class_07;

/**
 * 最长递增子序列的长度
 * 时间复杂度: O(N*N)
 * 优化之后: O(N*logN)
 */
public class Code_02_LIS {

	public static int[] lis1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		int[] dp = getdp1(arr);
		return generateLIS(arr, dp);
	}

	/**
	 * @param arr 原数组
	 * @return dp  [i]代表的意思是以i结尾的最长子序列的长度
	 */
	public static int[] getdp1(int[] arr) {
		int[] dp = new int[arr.length];   //dp[i]代表的意思是以i结尾的最长子序列的长度
		for (int i = 0; i < arr.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {  //==需要优化的地方==
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		return dp;
	}

	/**
	 * 根据dp数组生成最终的最长递增子序列，
	 * dp数组的每个值代表的是以i结尾的最长子序列的长度
	 */
	public static int[] generateLIS(int[] arr, int[] dp) {
		int len = 0; 	//最长递增子序列的长度
		int index = 0;  //最长递增子序列结尾的index
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > len) {
				len = dp[i];
				index = i;
			}
		}

		int[] lis = new int[len]; //最终的最长递增子序列
		lis[--len] = arr[index]; //填充最后的位置

		//从后往前找，值比当前数小，并且递增子序列的长度比当前的还要小1，说明就是当前最长递增子序列值之前的值；
		for (int i = index; i >= 0; i--) {
			if (arr[i] < arr[index] && dp[i] == dp[index] - 1) {
				lis[--len] = arr[i];
				index = i;
			}
		}
		return lis;
	}

	public static int[] lis2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		int[] dp = getdp2(arr);
		return generateLIS(arr, dp);
	}

	/**
	 * getdp1的优化，思路就是求dp[i]的时候，不去遍历之前的所有数字，
	 * 使用一个ends数组，意义：ends[b]==c，表示遍历到目前为止，在所有长度为b+1的递增序列中，最小的结尾数是c，
	 * 每次求arr[i]对应的dp[i]的时候，先从ends中找到第一个大于arr[i]的ends[j]，
	 * >如果没找到，说明这个数字比之前的数都大，此时最长子序列的长度要+1了，有效区也应该扩充了(ends数组扩充一位)
	 * >如果找到了，说明之前已经出现过了比arr[i]大的数字，此时arr[i]对应的dp[i]就应该取 j+1(不明白就看一下ends数组的意义)，此时ends[j]也要更新，因为长度为b+1的递增序列中，最小的结尾数已经变化了；
	 *
	 * 所以ends数组中保存的就是各个长度的递增序列中的，最小的结尾数，这个肯定是递增的，所以可以二分查找没有问题，但是为啥要保存这个长度的递增序列中的最小的结尾数呢？
	 * 因为根据这个最小值，可以判断num数组中的后续元素是否可以追加到既有IS中以形成更长的递增子序列，
	 * 假如取这个长度的递增序列中的最大的值，此时后续来了一个值，比这个长度的递增序列的最小值大，但是比前面提到的最大值小，此时这个值形成的递增子序列应该+1，但是如果保存的是最大值，此时就不会+1了，例子如下：
	 * 比如2,1,5,3,4 这个序列，ends如果保存的是2,5，那4的时候的最长IS就是2了，实际应该是3，ends应该为1,3，此时最长IS为1,3,4
 	 */
	public static int[] getdp2(int[] arr) {
		int[] dp = new int[arr.length];   //dp数组，和上述的一样
		int[] ends = new int[arr.length]; //ends[b]==c，表示遍历到目前为止，在所有长度为b+1的递增序列中，最小的结尾数是c，
		ends[0] = arr[0]; //ends[0]=2的含义是，在遍历过arr[0]之后，所有长度为1的递增序列中(此时只有2),最小的结尾数是2，
		dp[0] = 1;
		int right = 0;  //有效区的概念，right后面的数没有意义，
		int l = 0;
		int r = 0;
		int m = 0;
		for (int i = 1; i < arr.length; i++) {  //遍历这个数组
			l = 0;
			r = right;
			while (l <= r) {  //在ends中找到最左边的大于或等于arr[i]的数，表示之前出现的第一个比arr[i]大的数，如果找不到，说明arr[i]比之前的所有数字都大，此时最长子序列的长度要+1了，有效区也应该扩充了，
				m = (l + r) / 2;
				if (arr[i] > ends[m]) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			}
			right = Math.max(right, l);
			ends[l] = arr[i];
			dp[i] = l + 1;
		}
		return dp;
	}

	// for test
	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 3, 6, 4, 8, 9, 7 };
		printArray(arr);
		printArray(lis1(arr));
		printArray(lis2(arr));
	}
}
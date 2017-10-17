package org.clay.Chap12;

/**
 * 返回一个数组中的最长递增子序列
 * @author clay
 */
public class LongestIncreasingSubsequence {
	/**
	 * @param array    数组
  	 * @param n		         数组长度
	 */
	public int getLIS(int[] array, int n){
	
		int[] dp = new int[n];	//dp表示在必须以arr[i] 这个数结尾的情况下，  arr[0...i] 中的最大递增子序列的长度。
		int res = 0;
		dp[0] = 1;		//以第一个数结尾的序列的最大递增子序列肯定只有它自己。
		
		for(int i = 1; i < n; i++){
			int max = 0;		//求以array[i]结尾情况下的最长递增子序列长度   也就是dp[i] 的值。在0到i-1的所有比array[i]小的数字
								//都可以作为倒数第二个数，在其中选择以内个数结尾的最大递增子序列更大作为我们的倒数第二个数。
			int j = 0;
			while(j < i){
				if(array[j] < array[i] && dp[j] > max){
					max = dp[j];
				}
				j++;
			}
			dp[i] = max+1;
		}
		for(int i = 0; i < n; i++){
			if(res < dp[i]){
				res = dp[i];
			}
		}
		return res;
	}
}

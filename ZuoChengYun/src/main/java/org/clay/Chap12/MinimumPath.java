package org.clay.Chap12;

/**
 * 最小路径和问题
 * 矩阵m，左上角走到右下角，只能向右或向下，路径上所有数字累加起来就是路径和
 * @author clay
 */
public class MinimumPath {
	public int getMin(int[][] map, int m, int n){	//行数为m，列数为n
		
		int[][] dp = new int[m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				dp[i][j] = 0;
			}
		}
		dp[0][0] = map[0][0];	//左上角位置
		for(int i = 1; i < m; i++){		//第一列的值等于dp中上一个数字和map中当前位置数字的加和
			dp[i][0] = dp[i-1][0] + map[i][0];
		}
		for(int j = 1; j < n; j++){
			dp[0][j] = dp[0][j-1] + map[0][j];	//第一行的值等于dp中上一个数字和map中当前位置数字的加和
		}
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + map[i][j];
			}
		}
		return dp[m-1][n-1];
	}
}

package org.clay.Chap12;
/**
 * 找零钱的方法 数组中没有重复的，
 * 且每个数字都可以重复使用 
 * aim代表要找的钱数
 * @author clay
 */
public class Exchange {

	/**
	 * dp
	 */
	public int coins3(int[] penny, int aim) {
		if (penny == null || penny.length == 0 || aim < 0) {
			return 0;
		}
		int[][] dp = new int[penny.length][aim+1];  //生成行数为N(penny的长度)，列数为aim+1的矩阵dp
										//penny[i][j]的含义是在使用penny[0...i]货币的情况，组成钱数j有多少种方法
		//第一列，均为1;  组成矩阵第一列的值表示组成钱数为0的方法数，
		for(int i = 0; i < penny.length; i++){
			dp[i][0] = 1;
		}
		//第一行，k*arr[0]为0;	表示只能使用array[0]这一种货币的情况下，组成钱的方法数，也就是说array[0]的整数倍的位置才能被array[0]这种货币组成
		for(int j = 0; j*penny[0] <= aim; j++){
			dp[0][j*penny[0]] = 1;
		}
		/**
		 * 具体理解看图示动态规划-找零钱步骤.png  和     什么是动态规划方法.png(优化过)
		 */
		for(int i = 0; i < penny.length; i++){
			for(int j = 1; j < aim+1; i++){
				
				dp[i][j] = dp[i-1][j];
				dp[i][j] += j-penny[i]>=0?dp[i][j-penny[i]]:0;
			};
		}
		return dp[penny.length-1][aim];//右下角位置。
	}
	/**
	 * 记忆搜索
	 */
	public int coins2(int[] arr, int aim) {

		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int[][] map = new int[arr.length+1][aim + 1];	//index, aim是变化的，并且可以代表递归过程
		return precess2(arr, 0, aim, map);
	}

	private int precess2(int[] arr, int index, int aim, int[][] map) {
		int res = 0;
		if (index == arr.length) {
			res = aim == 0 ? 1 : 0;
		} else {
			int mapValue = 0;
			for (int i = 0; arr[index] * i <= aim; i++) {
				mapValue = map[index + 1][aim - arr[index] * i];  //查询之前有没有保存过这个值。

				if (mapValue != 0) {
					res += mapValue == -1 ? 0 : mapValue;
				} else {
					res += precess2(arr, index + 1, aim - arr[index] * i, map);
				}
			}
		}
		map[index][aim] = res == 0 ? -1 : res;	//递归完成之后，把递归的结果放回到它对应的位置中。
		return res;
	}

	/**
	 * 暴力搜索 复杂度高的原因是：
	 * 在使用0张5元和1张10元的情况下，后续将求p1(arr, 2, 990);
	 * 在使用2张5元和0张10元的情况下，后续还是会求p1(arr, 2, 990);
	 */
	public int coins1(int[] arr, int aim) {

		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		return precess1(arr, 0, aim);
	}

	/**
	 * @param index  当前正在用第几张货币在循环，
	 * @param aim	   要找到的钱数
	 * @return
	 */
	private int precess1(int[] arr, int index, int aim) {
		int res = 0;
		if (index == arr.length) {
			res = aim == 0 ? 1 : 0;
		} else {
			/*
			 * 例如arr{5,10,25,1} 循环过程
			 * 用0张5元货币，10,25,1    组成剩下的1000
			 * 用1张5元货币，10,25,1    组成剩下的995
			 * 用2张5元货币，10,25,1    组成剩下的990
			 * ....
			 * */
			for (int i = 0; arr[index] * i <= aim; i++) {
				res += precess1(arr, index + 1, aim - arr[index] * i);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Exchange ee = new Exchange();
		int[] array = new int[] { 5, 10, 25, 1 };
		System.out.println(ee.coins2(array, 1000));
	}
}

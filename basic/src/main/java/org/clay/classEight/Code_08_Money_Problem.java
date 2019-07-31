package org.clay.classEight;

/**
 * 数组中的元素几个数字相加能不能得到aim
 */
public class Code_08_Money_Problem {

	public static boolean money1(int[] arr, int aim) {
		return process1(arr, 0, 0, aim);
	}

	public static boolean process1(int[] arr, int i, int sum, int aim) {
		if (sum == aim) {
			return true;
		}
		// sum != aim
		if (i == arr.length) {
			return false;
		}
		return process1(arr, i + 1, sum, aim) || process1(arr, i + 1, sum + arr[i], aim);
	}

	public static boolean money2(int[] arr, int aim) {
		boolean[][] dp = new boolean[arr.length + 1][aim + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i][aim] = true;
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = aim - 1; j >= 0; j--) {
				dp[i][j] = dp[i + 1][j];
				if (j + arr[i] <= aim) {
					dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
				}
			}
		}
		return dp[0][0];
	}

    /**
     * 和子序列的树形图一致，
     * 图示：数组中的元素相加能不能得到aim
     * @param arr
     * @param index   第几层
     * @param sum     当前形成的和
     * @param aim
     * @return
     */
	public static boolean isSum(int[] arr,int index,int sum, int aim){

	    if(index == arr.length){
	        return sum == aim;
        }

	    return isSum(arr,index+1,sum,aim) || isSum(arr,index+1,sum+arr[index],aim);
    }

	public static void main(String[] args) {
		int[] arr = { 1, 4, 8 };
        int aim = 12;
//		System.out.println(money1(arr, aim));
//		System.out.println(money2(arr, aim));

        isSum(arr,0,0,aim);
	}

}

package org.clay.Chap12;

import java.lang.reflect.Array;

/**
 * 找零钱的方法 数组中没有重复的， 且每个数字都可以重复使用 aim代表要找的钱数
 * 
 * @author clay
 */
public class Exchange {

	/**
	 * 记忆搜索
	 */
	public int coins2(int[] arr, int aim) {

		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int[][] map = new int[arr.length][aim + 1];
		return precess2(arr, 0, aim, map);
	}

	private int precess2(int[] arr, int index, int aim, int[][] map) {
		int res = 0;
		if (index == arr.length) {
			res = aim == 0 ? 1 : 0;
		} else {
			int mapValue = 0;
			for (int i = 0; arr[index] * i <= aim; i++) {
				mapValue = map[index + 1][aim - arr[index] * i];

				if (mapValue != 0) {
					res += mapValue == -1 ? 0 : mapValue;
				} else {
					res += precess2(arr, index + 1, aim - arr[index] * i, map);
				}
			}
		}
		map[index][aim] = res == 0 ? -1 : res;
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

	private int precess1(int[] arr, int index, int aim) {
		int res = 0;
		if (index == arr.length) {
			res = aim == 0 ? 1 : 0;
		} else {
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

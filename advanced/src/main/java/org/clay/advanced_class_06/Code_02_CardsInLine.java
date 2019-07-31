package org.clay.advanced_class_06;

public class Code_02_CardsInLine {

	public static int win1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
	}

	/**
	 * 表示如果纸牌只剩下标在begin~end之间的几个了，那么作为先拿者，纸牌被拿完后，先拿者能达到的最大分数
	 * @param arr
	 * @param begin
	 * @param end
	 * @return
	 */
	public static int f(int[] arr, int begin, int end) {
		if (begin == end) {  // 如果只有一张纸牌，那么该纸牌分数就是先拿者能达到的最大分数，直接返回，无需决策。
			return arr[begin];
		}
		//否则先拿者A的第一次决策只有两种情况：
		//先拿最左边的arr[beginIndex]，那么在A拿完这一张之后就会作为后拿者参与到剩下的(begin+1)~end之间的纸牌的决策了，这一过程可以交给s()来做。
		//先拿最右边的arr[endIndex]，那么在A拿完这一张之后就会作为后拿者参与到剩下的begin~(end-1)之间的纸牌的决策了，这一过程可以交给s()来做。
		return Math.max(arr[begin] + s(arr, begin + 1, end), arr[end] + s(arr, begin, end - 1));
	}

	/**
	 * 表示如果纸牌只剩下标在begin~end之间的几个了，那么作为后拿者，纸牌被拿完后，后拿者能达到的最大分数
	 * @param arr
	 * @param begin
	 * @param end
	 * @return
	 */
	public static int s(int[] arr, int begin, int end) {
		if (begin == end) {  //如果只有一张纸牌，那么作为后拿者没有纸牌可拿，分数为0，直接返回
			return 0;
		}
		//假设先拿者A拿到了arr[beginIndex]，那么去掉该纸牌后，对于剩下的(begin+1)~end之间的纸牌，后拿者B就转变身份成了先拿者，这一过程可以交给f()来处理。
		//假设先拿者A拿到了arr[endIndex]，那么去掉该纸牌后，对于剩下的begin~(end-1)之间的纸牌，后拿者B就转变身份成了先拿者，这一过程可以交给f()来处理。

		//这里取两种情况中结果较小的一种，是因为这两种情况是我们假设的，但先拿者A绝顶聪明，他的选择肯定会让后拿者尽可能拿到更小的分数。
		//比如arr=[1,2,100,4]，虽然我们的假设有先拿者拿1和拿4两种情况，对应f(arr,1,3)和f(arr,0,2)，但实际上先拿者不会让后拿者拿到100，
		//因此取两种情况中结果较小的一种。
		return Math.min(f(arr, begin + 1, end), f(arr, begin, end - 1));
	}

	public static int win2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int[][] f = new int[arr.length][arr.length];
		int[][] s = new int[arr.length][arr.length];
		for (int j = 0; j < arr.length; j++) {
			f[j][j] = arr[j];
			for (int i = j - 1; i >= 0; i--) {
				f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
				s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
			}
		}
		return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 9, 1 };
		System.out.println(win1(arr));
		System.out.println(win2(arr));
	}
}
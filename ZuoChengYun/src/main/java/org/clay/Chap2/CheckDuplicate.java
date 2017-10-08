package org.clay.Chap2;

/**
 * 判断一个数组（非排好序）中是否有重复值， 要求额外空间复杂对为O(n)
 * @author clay
 */
public class CheckDuplicate {

	/**
	 * 如果没有额外空间复杂对为O(n)的限制的话，应该用哈希表来实现 
	 * 先排序，后判断 堆排序如果用递归实现的话，空间复杂度是logN -函数调用栈的原因。 
	 * 所以应该采用非递归的形式
	 */
	public boolean checkDuplicate(int[] array, int n) {

		heapSort(array);
		for (int i = 0; i < n - 1; i++) {
			if (array[i] == array[i + 1]) {
				return true;
			}
		}
		return false;
	}

	private void heapSort(int[] a) {
		int hi = a.length - 1;
		// 建堆
		for (int i = (hi - 1) / 2; i >= 0; i--) {
			sink(a, i, hi);
		}
		// 下沉排序
		for (int i = hi; i >= 0; i--) {
			swap(a, 0, i);
			sink(a, 0, i - 1);
		}
	}

	private void sink(int[] a, int lo, int hi) {
		int child;
		while ((child = lo * 2 + 1) <= hi) {
			if (child < hi && a[child] < a[child + 1])
				child++;
			if (a[lo] >= a[child])
				break;
			swap(a, lo, child);
			lo = child;
		}
	}

	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}

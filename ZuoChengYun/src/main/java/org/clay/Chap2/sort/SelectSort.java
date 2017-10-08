package org.clay.Chap2.sort;

/**
 * 选择排序
 * @author clay
 */
public class SelectSort {

	public int[] selectSort(int[] array) {

		int tmp;
		for (int i = 0; i < array.length; i++) {

			int min = i;
			for (int j = i + 1; j < array.length; j++) {

				if (array[j] < array[min]) {
					min = j;
				}
			}

			if (min != i) {
				tmp = array[min];
				array[min] = array[i];
				array[i] = tmp;
			}

		}
		return array;
	}

	public static void main(String[] args) {

		SelectSort ss = new SelectSort();
		int[] array = new int[] { 1, 4, 6, 9, 7, 5, 3 };
		int[] sort = ss.selectSort(array);
		for (int i = 0; i < sort.length; i++) {
			System.out.println(array[i]);
		}
	}
}

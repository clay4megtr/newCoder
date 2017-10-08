package org.clay.Chap2.sort;

/**
 * 插入排序
 * @author clay
 */
public class InsertSort {

	public int[] insertSort(int[] array) {

		int temp;
		for (int i = 1; i < array.length; i++) {

			if (array[i] < array[i - 1]) {

				temp = array[i];

				int j;
				for (j = i - 1; array[j] > temp; j--) {
					array[j + 1] = array[j];
				}
				array[j + 1] = temp;
			}
		}

		return array;
	}

	public static void main(String[] args) {

		InsertSort is = new InsertSort();
		int[] array = new int[] { 1, 4, 6, 9, 7, 5, 3 };
		int[] sort = is.insertSort(array);
		for (int i = 0; i < sort.length; i++) {
			System.out.println(array[i]);
		}
	}
}

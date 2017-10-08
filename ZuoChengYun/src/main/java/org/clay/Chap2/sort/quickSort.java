package org.clay.Chap2.sort;

public class quickSort {

	public void quickSort(int[] array, int left, int right){
		
		if(left < right){
			int middle = getMiddle(array, left, right);
			quickSort(array, left, middle);
			//quickSort(array, middle+1, right);
			left = middle+1;	//这两句效果其实是一样的，尾递归
		}
	}

	private int getMiddle(int[] array, int left, int right) {
		int m = left + (right - left) / 2;

		if (array[left] > array[right]) {
			swap(array, left, right);
		}
		if (array[m] > array[right]) {
			swap(array, m, right);
		}

		if (array[m] > array[left]) {
			swap(array, m, left);
		}

		int tmp = array[left];// 基数
		
		while(left < right){
			
			while(left < right && array[right] >= tmp){
				right--;
			}
			array[left] = array[right];
			
			while(left < right && array[left] <= tmp){
				left++;
			}
			array[right] = array[left];
		}
		array[left] = tmp;
		return left;
	}
	
	public void swap(int[] array, int left, int right){
	
		int tmp = array[left];
		array[left] = array[right];
		array[right] = tmp;
	}
	
	public static void main(String[] args) {
		quickSort qs = new quickSort();
		int[] array = new int[] { 1, 4, 6, 9, 7, 5, 3 };
		qs.quickSort(array, 0, array.length-1);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}

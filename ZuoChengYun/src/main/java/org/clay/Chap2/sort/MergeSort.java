package org.clay.Chap2.sort;

/**
 * 归并排序
 * @author clay
 */
public class MergeSort {

	/**
	 * 递归划分
	 */
	public void mergeSort(int[] array, int left, int right){
		
		int middle = (left + right) / 2;
		if(left < right){
			mergeSort(array, left, middle);
			mergeSort(array, middle+1, right);
			merge(array, left, middle, right);
		}
	}
	/**
	 * 合并
	 */
	private void merge(int[] array, int left,int middle, int right) {
		
		int[] tmpArray = new int[array.length];
		
		int rightStart = middle+1;
		
		int tmp = left;	
		
		int third = left;	//中间数组tmpArray的下标
		
		while(left <= middle && rightStart <= right){
			
			if(array[left] <= array[rightStart]){
				tmpArray[third++] = array[left++];
			}else{
				tmpArray[third++] = array[rightStart++];
			}
		}
		
		while(left <= middle){
			tmpArray[third++] = array[left++];
		}
		
		while(rightStart <= right){
			tmpArray[third++] = array[rightStart++];
		}
		
		//把tmpArray临时数组的元素重新拷贝到a数组中。
		while(tmp <= right){
			array[tmp] = tmpArray[tmp++];
		}
	}
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] array = new int[] { 1, 4, 6, 9, 7, 5, 3 };
		ms.mergeSort(array, 0, array.length-1);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}

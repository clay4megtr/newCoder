package org.clay.Chap2.sort;

/**
 * 冒泡排序
 * @author clay
 */
public class BubbleSort {

	public int[] bubbleSort(int[] array){
		
		boolean flag = true;
		for(int i = 0; i < array.length && flag; i++){
			
			flag = false;
			for(int j = array.length-1; j > i; j--){
				
				if(array[j] < array[j-1]){
					int tmp = array[j];
					array[j] = array[j-1];
					array[j-1] = tmp;
					flag = true;
				}
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		
		BubbleSort bs = new BubbleSort();
		int[] array = new int[]{1,4,6,9,7,5,3};
		int[] sort = bs.bubbleSort(array);
		for(int i = 0; i < sort.length; i++){
			System.out.println(array[i]);
		}
	}
}

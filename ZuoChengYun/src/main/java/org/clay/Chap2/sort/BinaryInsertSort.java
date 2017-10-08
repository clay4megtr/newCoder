package org.clay.Chap2.sort;

/**
 * 二分法插入排序
 * @author clay
 */
public class BinaryInsertSort {

	public int[] binaryInsertSort(int[] array){
		
		for(int i = 0; i < array.length; i++){
			
			int temp = array[i];
			
			int left = 0; 
			int right = i - 1;
			int mid = 0;
			
			//因为最终的条件有left=eight,那么最后的结果一定是left在right的右边，所以，left的位置，就是要插入数据的位置。
			while(left <= right){
				
				mid = (left + right) /2;
				
				if(temp >= array[mid]){
					left = mid+1;
				}
				
				if(temp < array[mid]){
					right = mid-1;
				}
			}
			//把left位置的值以后的值都往后移动一位
			for(int j = i-1; j >= left; j--){
				array[j+1] = array[j];
			}
			
			//如果left的值变化了，就移动位置。
			if(left != i){
				array[left] = temp;
			}
		}
		return array;
	}

	public static void main(String[] args) {
		BinaryInsertSort bi = new BinaryInsertSort();
		int[] array = new int[]{1,4,6,9,7,5,3};
		int[] sort = bi.binaryInsertSort(array);
		for(int i = 0; i < sort.length; i++){
			System.out.println(array[i]);
		}
	}
}

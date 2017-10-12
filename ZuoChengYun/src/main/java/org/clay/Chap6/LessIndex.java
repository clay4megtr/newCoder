package org.clay.Chap6;

/**
 * 无序数组，
 * 任意相邻的两个元素值都不重复
 * 返回任意一个局部最小的位置
 * 即array[i] 同时小于 array[i-1]   array[i+1]
 * 时间复杂度O(LogN)
 * @author clay
 */
public class LessIndex {
	
	public int getLessIndex(int[] array){
		
		if(array == null || array.length == 0){
			return -1;
		}
		if(array.length == 1 || array[0] < array[1]){
			return 0;
		}
		if(array[array.length-1] < array[array.length-2]){
			return array.length-1;
		}
		
		int left = 0;
		int right = array.length-2;
		int middle = 0;
		
		while(left <= right){
			
			middle = left+(right-left)/2;
			//说明此时往左边是减小的。
			if(array[middle] > array[middle-1] && array[middle] < array[middle+1]){
				right = middle-1;
			}
			//说明此时往右边边是减小的。
			if(array[middle] < array[middle-1] && array[middle] > array[middle+1]){
				left = middle+1;
			}
			//说明此时往左右两边都是减小的。此时往哪边走都可以
			if(array[middle] > array[middle-1] && array[middle] > array[middle+1]){
				left = middle+1;
			}
			//说明找到了
			if(array[middle] < array[middle-1] && array[middle] < array[middle+1]){
				return middle;
			}
		}
		return -1;
	}
}

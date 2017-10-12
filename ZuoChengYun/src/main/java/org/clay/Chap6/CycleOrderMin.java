package org.clay.Chap6;

/**
 * 有序循环数组
 * 1,2,3,3,4
 * 4,1,2,3,3
 * 返回最小值
 * @author clay
 */
public class CycleOrderMin {

	public int getCycleOrderMin(int[] array){
		int left = 0;
		int right = array.length-1;
		int middle = 0;
		//此时说明数组是有序的， 直接返回最左边的值即可
		if(array[left] < array[right]){
			return array[left];
		}
		//array[left] >= array[s]  说明数组包含循环的部分，例如     2,2,3,1,2
		while(left < right){
			middle = left+(right-left)/2;
			//循环过的部分指的就是之前位置没有移动到前面的数据
			if(array[left] > array[middle]){
				//说明最小值只有可能出现在l到m之间，因为只有array[middle]是循环过的部分时，才会有array[left] > array[middle]
				//7,8,9,1,2,3,4,5,6      l->7    r->6   m->2
				right = middle-1;
			}
			if(array[middle] > array[right]){
				//说明最小值只有可能出现在m到r之间，因为只有array[middle]不是循环过的部分时，才会有array[middle] > array[right]
				//4,5,6,7,8,9,1,2,3    	 l->4    r->3   m->8
				left = middle+1;
			}
			//此时说明array[left] <= array[middle]
			//	   array[middle] <= array[right]
			//	   array[left] >= array[right]
			// 说明array[left] = array[middle] = array[right]
			// 2,2,2,2,....2,1,2.....2,2,2,2,2		1无论出现在哪里，都满足有序循环数组的条件
			// 此时只能遍历
			break;
		}
		//如果left == right  说明是正常情况
		if(left == right){
			return array[left];
		}
		//否则就是2,2,2,2,....2,1,2.....2,2,2,2,2的情况
		int min = array[left];
		while(left <= right){
			if(array[left] < array[min]){
				min = array[left];
			}
			left++;
		}
		return min;
	}
}

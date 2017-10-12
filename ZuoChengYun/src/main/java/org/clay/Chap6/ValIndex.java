package org.clay.Chap6;

/**
 * 不含有重复元素
 * 寻找:  arr[i] = i，要最左边的位置
 * 没有满足的，返回-1
 * @author clay
 */
public class ValIndex {

	public int getValIndex(int[] array){
		
		int res = -1;
		
		if(array[0] > array[array.length-1]){
			//此时说明所有的元素都是 > array.length-1 的，因为位置的取值最多只能是array.length-1，所以返回-1即可
			return res;
		}
		if(array[array.length-1] < array[0]){
			//此时说明所有的元素都是 > array.length-1 的，因为位置的取值只能是0到array.length-1，所以返回-1即可
			return res;
		}
		
		int left = 0;
		int right = array.length-1;
		int middle = 0;
		
		while(left <= right){
			middle = left + (right-left)/2;
			
			if(array[middle] > middle){
				//递增的增量最小是1，而位置的增量则严格是1，所以从middle到n范围上都不会出现array[i] = i 这种情况
				right = middle-1;
			}
			
			if(array[middle] < middle){
				//从middle到left是严格递减的，  递减的增量最小是1，而位置的减小则严格是1，
				//所以从left到middle范围上都不会出现array[i] = i 这种情况
				left = left+1;
			}
			
			if(array[middle] == middle){
				res = middle;
				right = middle-1;//因为找的是最左边的位置。
			}
		}
		return res;
	}
}

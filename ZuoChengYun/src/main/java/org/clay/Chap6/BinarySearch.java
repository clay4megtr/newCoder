package org.clay.Chap6;

/**
 * 二分搜索
 * @author clay
 */
public class BinarySearch {

	/**
	 * 迭代
	 * @return
	 */
	public int iterator(int[] array, int val){
		
		int start = 0;
		int end = array.length;
		int middle = 0;
		
		while(start <= end){
			
			middle = start + (end-start)/2;
			
			if(array[middle] == val){
				return middle;
			}else if(array[middle] < val){
				start = middle+1;
			}else{
				end = middle-1;
			}
		}
		
		return -1;
	}
	
	/**
	 * 递归
	 * @return
	 */
	public int recurve(int[] array, int val, int start, int end){
		
		int middle = start + (end-start)/2;
		if(array[middle] == val){
			return middle;
		}
		if(start >= end){//当start = end 的时候，middle = start，上面已经判断过了，所以如果执行到最后到这里的话，要加上等于号，
			return -1;
		}
		if(array[middle] > val){
			return recurve(array, val, start,middle-1);
		}else{
			return recurve(array, val, middle+1,end);
		}
	}
}

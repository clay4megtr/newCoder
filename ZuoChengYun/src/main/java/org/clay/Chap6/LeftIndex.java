package org.clay.Chap6;

/**
 * 有序数组array，
 * 有重复的
 * 整数num
 * array中找到这个array出现的最左边的位置。
 * @author clay
 */
public class LeftIndex {
	public int getLeftIndex(int[] array, int num){
		
		int left = 0;
		int right = array.length-1;
		int middle = 0;
		int res = -1;
		
		while(left <= right){
			middle = left + (right-left)/2;
			
			//找到在最左边出现的位置。
			//关键就是这里了，当array[middle] == num的时候，此时不知道左边还有没有，所以继续向左搜索.
			if(array[middle] == num){
				res = middle;
				right = right-1;
			}
			//此时说明最右边的数字都是大于num的
			if(array[middle] > num){
				right = right-1;
			}
			//此时说明最左边的数字都是小于num的
			if(array[middle] < num){
				left = left+1;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		LeftIndex li = new LeftIndex();
		int[] array = new int[]{1,2,3,3,3,3,4,4,4,4,4,4,4,4,4};
		System.out.println(li.getLeftIndex(array, 3));
	}
}

package org.clay.Chap2;

/**
 * 需要排序的最短子数组的长度
 * 1,4,6,5,9,10    返回2
 * @author clay
 */
public class ShorestSubArray {

	/**
	 * 时间复杂度O(n)
	 * 空间复杂度O(1)
	 * 先从左往右，再从右往左
	 */
	public int shorestSubArray(int[] array, int n){
		
		int max = array[0];  //从左往右找到的最大值
		int min = array[n-1];//从左往右找到的最大值
		
		int leftIndex = 0;;
		int rightIndex = n-1;
		
		for(int i = 1; i < array.length; i++){
			
			if(array[i] > max){
				max = array[i];
			}else{
				leftIndex = i;
			}
		}
		
		for(int i = n-2; i > 0; i--){
			
			if(array[i] < min){
				min = array[i];
			}else{
				rightIndex = i;
			}
		}

		if(leftIndex == 0){	//说明没动过
			return 0;
		}else{
			return leftIndex-rightIndex+1;
		}
	}
	
	public static void main(String[] args) {
		ShorestSubArray ssa = new ShorestSubArray();
		int[] array = new int[] { 1,4,6,5,9,10 };
		System.out.println(ssa.shorestSubArray(array, array.length));
	}
}

package org.clay.Chap2;

/**
 * 二维数组中(行和列都是排好序的)寻找是否包含某个数
 */
public class TwoDimStrSearch {

	/**
	 * 时间复杂度为O(m+n)
	 */
	public boolean twoDimStrSearch(int target, int [][] array) {

    	int row = 0; 
    	int col = array[0].length - 1;
    	
    	while(row <= array.length-1 && col>= 0){
    		
    		if(target == array[row][col]){
    			return true;
    		}else if(target > array[row][col]){
    			row++;
    		}else{
    			col--;
    		}
    	}
    	return false;
    }
}

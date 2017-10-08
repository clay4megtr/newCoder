package org.clay.Chap1;

/**
 * 把给定字符位置的左右两边互换
 * @author clay
 */
public class MoveString {

	public String reverse(String source){
		
		char[] array = source.toCharArray();
		
		int n = source.length() -1;
		
		int halfLength = n/2;
		
		for(int i = 0; i < halfLength; i++){
			
			char temp = array[i];
			array[i] = array[n - i];
			array[n - i] = temp;
		}
		return new String(array);
	}
	
	
	public String swapString(String str, int i){
		
		
		return null;
	}
}

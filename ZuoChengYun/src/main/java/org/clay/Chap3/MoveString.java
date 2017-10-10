package org.clay.Chap3;

/**
 * 把给定字符位置的左右两边互换
 * 时间复杂度O(N),时间复杂度O(1) 
 * @author clay
 */
public class MoveString {

	public String reverse(String source){
		
		char[] array = source.toCharArray();
		
		int n = source.length() -1;
		
		int halfLength = n/2;
		
		for(int i = 0; i <= halfLength; i++){
			
			char temp = array[i];
			array[i] = array[n - i];
			array[n - i] = temp;
		}
		return new String(array);
	}
	
	public String swapString(String str, int i){
		
		String leftReverse = reverse(str.substring(0, i+1));
		String rightReverse = reverse(str.substring(i+1, str.length()));
		
		String result = reverse(leftReverse + rightReverse);
		
		return result;
	}
	
	public static void main(String[] args) {
		
		String str = "ABCDE";
		MoveString ms = new MoveString();
		
		String swapString = ms.swapString(str, 2);
		System.out.println(swapString);
	}
}

package org.clay.Chap8;

/**
 * 一个数组，只有一个数字出现了奇数次，
 * 其他的都出现了偶数次，打印这个数字，
 * 时间复杂度O(n), 空间复杂度O(1)
 * @author clay
 */
public class FindNumber {

	/**
	 * [C,B,D,A,A,B,C]
	 * n与0异或结果为n
	 * n与n异或结果为0s
	 * 
	 * 异或运算满足交换律
	 * 异或运算满足结合律
	 * 按照原始arr数组出现的顺序异或结果，与该数组异或的结果相同[A,A,B,B,C,D]
	 * eo与上述异或的结果为eo=D
	 */
	public void findNumber(int[] array){
		
		int eo = 0;
		for (int i = 0; i < array.length; i++) {
			eo ^= array[i];
		}
		System.out.println(eo);
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{3,2,4,1,1,2,3};
		FindNumber fn = new FindNumber();
		fn.findNumber(array);
	}
}

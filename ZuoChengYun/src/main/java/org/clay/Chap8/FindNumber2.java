package org.clay.Chap8;

/**
 * 一个数组，有两个数字出现了奇数次，
 * 其他的都出现了偶数次，打印这个数字，
 * 时间复杂度O(n), 空间复杂度O(1)
 * @author clay
 */
public class FindNumber2 {

	/**
	 * n与0异或结果为n
	 * n与n异或结果为0
	 * 假设出现了奇数次的两个数字是a和b
	 */
	public void findNumber(int[] array){
		
		int eo1 = 0;
		int eo2 = 0;
		
		for (int i = 0; i < array.length; i++) {
			eo1 ^= array[i];
		}
		//此时eo1 = a^b,因为a和b是不同的数，所以eo1不等于0
		//然后寻找eo1的32位中不为0的位，记为第k位置，说明a和b的第k位一定不一样。
		
		// 得到两个数右起第一个不相同的位  
		// 一个数和自己的相反数进行位与,得到的是原数中右起第一个为1,其余都为0的数  ,也就是只有第k位是1的数字。
		// 比如: 3-->0011 --> 0001
		int oneRight = eo1&(~eo1+1);
	
		for (int i = 0; i < array.length; i++) {
			if((array[i] & oneRight) != 0){		//eo2与array中第k位为1的整数进行异或，
				eo2 ^= array[i];				//异或完成后，eo2为a或者b中的一个，
			}
		}
		System.out.println(eo2 + "<------>" + (eo1^eo2));	//另一个数字等于eo1^eo2
	}
}

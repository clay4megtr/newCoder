package org.clay.Chap8;

/**
 * 返回两个数中较大的内个
 * 但是不能用任何比较判断
 * @author clay
 */
public class Bigger {

	/**
	 * 使异或表达式为true的条件是：有且仅有一个操作为true；
	 */
	public static int flip(int n){
		return n^1;
	}
	/**
	 * 取得32位整数的符号的函数
	 * 如果不是负数，则返回1，   是负数，则返回0 
	 */
	public static int sign(int n){
		return flip((n >> 31)&1);	
	}
	/**
	 * 方法1
	 * 我们不能直接比较，那么就用减法来判断，a - b值的符号，符号为正a大，符号为负b大。
	 * scA表示c的符号，scB表示c的相反的符号，
	 * scA是1返回a，scA是0返回B.
	 * 但是有局限性，那就是a-b的值可能出现溢出，返回结果不正确。
	 */
	public static int getMax1(int a, int b){
		int c = a-b;
		int scA = sign(c);
		int scB = flip(scA);
		return a*scA + b*scB;	//scA和scB中只会有一个为1，另外一个为0，如果a-b不是负数，那么scA为1，scB为0，
															 //如果a-b是负数，那么scA为0，scB为1，
	}
	/**
	 * 方法2
	 * 先比较a与b两个数的符号，符号不同difSab==1，sameSab==0；直接返回符号为正的那个数。
	 * 如果a为0或正，那么b为负(sa==1,cs==0)，则返回a;
	 * 如果a为负，那么b为0或正(sa==0,cs==1)，则返回b;
	 * 
	 * 如果符号相同difSab==0,sameSab==1,这种情况下,a-b的值绝对不会溢出，那么就看c的符号。
	 * 如果c=a-b,为正返回a;
	 * 如果c=a-b,为负返回b;
	 */
	public static int getMax2(int a, int b){
		int c = a-b;
		int as = sign(a);	//a的符号，as==1表示a为非负，as==0表示a为负，
		int bs = sign(b); 	//b的符号，bs==1表示b为非负，bs==0表示b为负，
		
		int cs = sign(c);	//a-b的符号，
		
		int difab = as^bs;	//表示a和b是否符号不相同，不相同为1，相同为0，
		
		int sameab = flip(difab);	//表示a和b是否符号相同，相同为1，不相同为0，
		
		int returnA = difab*as + sameab*cs;
		int returnB = flip(returnA);
		return a*returnA + b*returnB;
	}
}

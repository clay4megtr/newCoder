package org.clay.Chap3;

/**
 * 判断一个字符串是不是整体有效的括号字符串
 * @author clay
 */
public class BacketAvai {

	/**
	 * 时间复杂度O(n)
	 */
	public boolean isBacketAvai(String source){
		
		int num = 0;   // "(" 出现的次数和  ")" 出现次数的差值
		
		for(int i = 0; i < source.length(); i++){
			if((source.charAt(i) + "").equals("(")){
				num++;
			}
			if((source.charAt(i) + "").equals(")")){
				num--;
			}
			
			if(num < 0){
				break;		//此时说明右边的")"比左边的"(" 多了。 直接终止返回false即可。
			}
		}
		
		if(num == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) {
		BacketAvai ba = new BacketAvai();
		System.out.println(ba.isBacketAvai("(())"));
	}
}

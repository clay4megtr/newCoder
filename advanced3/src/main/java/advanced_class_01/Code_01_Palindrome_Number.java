package advanced_class_01;

public class Code_01_Palindrome_Number {

	public static boolean isPalindrome(int n) {
		if (n < 0) {
			return false;
		}

		int help = 1;

		/*while(help <= n){
			help *= 10;  //可能会溢出，
		}
		help /= 10;*/

		while (n / help >= 10) {   //基础，只有多写才能搞定
			help *= 10;  // help 找到这个数字十进制的最高位；
		}
		while (n != 0) {
			if (n / help != n % 10) {  // n / help : 最高位，n % 10: 最低位
				return false;
			}
			n = (n % help) / 10;  //n % help：去掉最高位，再 / 10: 去掉最低位
			help /= 100;  // 	help / 100
		}
		return true;
	}
}
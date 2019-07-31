package advanced_class_01;

public class Code_07_Find_the_Closest_Palindrome {

	public static String nearestPalindromic(String n) {
		Long num = Long.valueOf(n);
		Long raw = getRawPalindrome(n); //得到原始回文
		Long big = raw > num ? raw : getBigPalindrome(raw);		//求比这个数大的回文
		Long small = raw < num ? raw : getSmallPalindrome(raw);  //求比这个数小的回文
		return String.valueOf(big - num >= num - small ? small : big);
	}

	public static Long getRawPalindrome(String n) {
		char[] chs = n.toCharArray();
		int len = chs.length;
		for (int i = 0; i < len / 2; i++) {
			chs[len - 1 - i] = chs[i];
		}
		return Long.valueOf(String.valueOf(chs));
	}

	public static Long getBigPalindrome(Long raw) {
		char[] chs = String.valueOf(raw).toCharArray();
		char[] res = new char[chs.length + 1];
		res[0] = '0'; //最高位多准备一个0，防止999这样的数字需要升位
		for (int i = 0; i < chs.length; i++) {
			res[i + 1] = chs[i];
		}
		int size = chs.length;
		// 在 (size - 1) / 2 + 1 位置处做加法
		for (int j = (size - 1) / 2 + 1; j >= 0; j--) {
			if (++res[j] > '9') {
				res[j] = '0';
			} else {
				break;
			}
		}
		int offset = res[0] == '1' ? 1 : 0;
		size = res.length;
		for (int i = size - 1; i >= (size + offset) / 2; i--) {
			res[i] = res[size - i - offset];
		}
		return Long.valueOf(String.valueOf(res));
	}

	public static Long getSmallPalindrome(Long raw) {
		char[] chs = String.valueOf(raw).toCharArray();
		char[] res = new char[chs.length];
		int size = res.length;
		for (int i = 0; i < size; i++) {
			res[i] = chs[i];
		}
		for (int j = (size - 1) / 2; j >= 0; j--) {
			if (--res[j] < '0') {
				res[j] = '9';
			} else {
				break;
			}
		}
		if (res[0] == '0') { //最高位减为0了
			res = new char[size - 1];
			for (int i = 0; i < res.length; i++) {
				res[i] = '9';  //后面位置全是9，然后返回
			}
			return size == 1 ? 0 : Long.parseLong(String.valueOf(res)); //空字符串直接返回0即可；
		}
		//最高位不是0，直接拷贝返回即可；
		for (int k = 0; k < size / 2; k++) {
			res[size - 1 - k] = res[k];
		}
		return Long.valueOf(String.valueOf(res));
	}
}
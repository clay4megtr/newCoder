package org.clay.Test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		String sourceStr = reader.nextLine(); // 源字符串

		if(sourceStr.length() <= 3){
			System.out.println(sourceStr.length());
		}
		
		String maxRepall = maxRepall(sourceStr);

		if(maxRepall.length() > 3){
			sourceStr = sourceStr.replaceFirst(maxRepall, "2["+ maxRepall + "]");
			sourceStr = sourceStr.replaceAll(maxRepall, "");
			System.out.println(sourceStr.length());
		}
		System.out.println(sourceStr.length());
	}

	// 寻找最长重复子串
	public static String maxRepall(String source) {

		int max = 0;
		int first = 0;
		int tmp = 0;

		for (int i = 1; i < source.length(); i++) {

			for (int j = 0; j < source.length() - i; j++) {
				if (source.charAt(j) == source.charAt(i + j)) {
					tmp++;
				} else {
					tmp = 0;
				}

				if (tmp > max) {
					max = tmp;
					first = j - tmp + 1;
				}
			}
		}
		if(max > 0){
			return source.substring(first, first + max);
		}
		return null;
	}
}

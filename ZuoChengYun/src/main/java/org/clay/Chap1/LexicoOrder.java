package org.clay.Chap1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 字符串数组拼接成字典顺序最小的
 * 最优解时间复杂度是O(N*logN)
 * 不能比较各自的字典顺序，然后按照这个顺序进行排序，而应该按照拼接之后的顺序就行排序
 * @author clay
 */
public class LexicoOrder {

	public String findSmalllest(String[] strs, int n){
		
		Arrays.sort(strs,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				String s1 = o1 + o2;
				String s2 = o2 + o1;
				
				return s1.compareTo(s2);
			}
		});
		
		String res = "";
		for(int i = 0; i < n; i++){
			res+=strs[i];
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		
		LexicoOrder lo = new LexicoOrder();
		
		String[] strs = new String[]{"b","ba"};
		
		String res = lo.findSmalllest(strs, 2);
		System.out.println(res);
	}
}

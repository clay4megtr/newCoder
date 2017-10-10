package org.clay.Chap3;

/**
 * 判断两个单词是否互为变形词语
 * str1="396",str2="936",返回true。
　　str1="396",str2="3691",返回false。
 * @author clay
 */
public class IsDeformation {

	/**
	 * 1.如果字符串str1和str2的长度不一样，直接返回false。
	 * 2.如果长度相同，假设出现的字符编码值在0-255之间，可以先申请一个整型数组arr，arr[a]=b代表字符编码为a的字符出现了b次。
	 * 初始时arr[0-255]的值都为0，然后遍历字符串str1，计算每种字符出现的次数。
	 * 比如，遍历的字符‘a',其编码值为97，则arr[97]++。同理，遍历字符串str2，arr[97]--。如果减少之后的值小于0，返回false。
	 * 如果遍历完str2，arr中的值也没出现，则返回false。
	 * 3.如果字符的种类很多，可以使用哈希表代替整型数组。
	 */
	public boolean isDeformation(String str1, String str2){
		
		if(str1==null||str2==null||str1.length()!=str2.length()){  
            return false;  
        } 
		char[]chas1=str1.toCharArray();  
        char[]chas2=str2.toCharArray(); 
        
        int[] arr = new int[256];
        for(int i = 0; i < str1.length(); i++){
        	arr[chas1[i]] ++;
        }
        /**
         * 只要str1和str2不是互为变形词语，那么肯定会出现arr[chas2[i]]--之后的值小于0，
         * 因为此时str2中肯定有一个词是str1中没有的。
         */
        for(int i = 0; i < str2.length(); i++){
        	if(arr[chas2[i]]-- == 0){
        		return false;
        	}
        }
		return true;
	}
	
	public static void main(String[] args) {
		IsDeformation id = new IsDeformation();
		System.out.println(id.isDeformation("396", "946"));
	}
}

package org.clay.classEight;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印一个字符串的所有子序列
 * 打算怎么尝试
 * 图片：穷尽所有的子序列
 * 树形图：每个字符串的位置都会有两个决策：1.要当前的字符，2.不要当前的字符
 * 这样就可以穷尽所有的子序列情况。
 */
public class Code_03_Print_All_Subsquences {

	public static void printAllSubsquence(String str) {
		char[] chs = str.toCharArray();
		process(chs, 0);
	}

	public static void process(char[] chs, int i) {
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
			return;
		}
		process(chs, i + 1);
		char tmp = chs[i];
		chs[i] = 0;
		process(chs, i + 1);
		chs[i] = tmp;
	}
	
	public static void function(String str) {
		char[] chs = str.toCharArray();
		process(chs, 0, new ArrayList<Character>());
	}
	
	public static void process(char[] chs, int i, List<Character> res) {
		if(i == chs.length) {
			printList(res);
		}
		List<Character> resKeep = copyList(res);
		resKeep.add(chs[i]);
		process(chs, i+1, resKeep);
		List<Character> resNoInclude = copyList(res);
		process(chs, i+1, resNoInclude);
	}
	
	public static void printList(List<Character> res) {
		// ...;
	}
	
	public static List<Character> copyList(List<Character> list){
		return null;
	}


    /**
     * 打印所有的子序列
     * res: 就是上级扔给我的字符串
     */
	public static void printAllSub(char[] str, int i,String res){

	    if(i == str.length){
            System.out.println(res);
            return;
        }

        /**
         * 每一步两条路都要走。要么不要当前的字符，要么要当前的字符。
         */
        printAllSub(str,i+1,res);//不要当前字符
        printAllSub(str,i+1,res+str[i]);//要当前字符
    }

	public static void main(String[] args) {
		String test = "abc";
		//printAllSubsquence(test);
        printAllSub(test.toCharArray(),0,"");
	}
}

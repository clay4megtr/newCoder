package org.clay.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
	
		int num = 6;
		
		/*
		 * 1	1
		 * 2	2
		 * 3	21
		 * 4	121
		 * 5	212
		 * 6	2121
		 * 7	12121
		 * 8	21212
		 * 9	212121
		 * 
		 * <= 42
		 * */
		//dp
		//
		if(num == 1){
			System.out.println(1);
		}
		if(num == 2){
			System.out.println(2);
		}
		
		List<Integer> list = new LinkedList<>();
		
		StringBuilder builder = new StringBuilder();
		
		while(true){
			
			if(num == 2){
				//说明就是这个数字
				list.add(2);
				break;
			}
			
			if(num == 0){
				//说明就是这个数字
				break;
			}
			
			if(num == 1){
				//说明剪错了
				list.clear();
				break;
			}
			
			num -= 2;
			num -= 1;
			list.add(2);
			list.add(1);
		}
		
		for (Integer integer : list) {
			builder.append(integer.toString());
		}
		
		int res = Integer.parseInt(builder.toString());
		System.out.println(res);
	}
}

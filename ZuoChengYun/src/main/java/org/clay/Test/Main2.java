package org.clay.Test;

import java.util.Scanner;
public class Main2 {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		String sourceStr = reader.nextLine();
	
		String[] split = sourceStr.split(" ");
		
		int length = Integer.parseInt(split[0]);//数组长度
		int operTime = Integer.parseInt(split[1]);
		
		if(length == 0){
			return;
		}
		
		int[] sourceArr = new int[length];
		for(int i = 0; i < sourceArr.length; i++){
			sourceArr[i] = i+1;
		}
		
		if(operTime == 0){
			for(int i= 0; i < sourceArr.length; i++){
				System.out.println(sourceArr[i]);
			}
			return;
		}
		
		while(reader.hasNext()){
			int pos = reader.nextInt();
			changeArr(sourceArr,pos);
		}
		
		for(int i= 0; i < sourceArr.length; i++){
			System.out.println(sourceArr[i]);
		}
		
		
//		Main2 main2 = new Main2();
//		int[] array = new int[]{1,2,3,4,5};
//		main2.changeArr(array, 4);
//		
//		for (int i = 0; i < array.length; i++) {
//			System.out.println(array[i]);
//		}
//		
//		main2.changeArr(array, 2);
//		for (int i = 0; i < array.length; i++) {
//			System.out.println(array[i]);
//		}
//		
//		main2.changeArr(array, 5);
//		for (int i = 0; i < array.length; i++) {
//			System.out.println(array[i]);
//		}
	}

	private static void changeArr(int[] sourceArr, int pos) {
		
		int index = 0;
		for(int i = 0; i < sourceArr.length; i++){
			if(sourceArr[i] == pos){
				index = i;
				break;
			}
		}
		for(int i = index-1; i >=0 ; i--){
			sourceArr[i+1] = sourceArr[i];
		}
		sourceArr[0] = pos;
	}
}

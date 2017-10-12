package org.clay.Test;

import java.util.Scanner;
public class Main4 {

	/*
	 *  5,4
		0,1,100
		3,4,100
		2,1,100
		3,2,100
	 */
	
	/*
	 *  输入
		5,4
		0,1,100
		3,4,100
		2,1,100
		0,2,100
		输出
		YES
	 * */
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		String line = reader.nextLine();
		String[] split = line.split(",");
		int posNum = Integer.parseInt(split[0]);
		int wayNum = Integer.parseInt(split[1]);
		
		int[][] array = new int[wayNum][2];
		
		int length = 0;//总长度
		
		int index = 0;
		while(reader.hasNextLine()){
			if(index < wayNum){
				String nextLine = reader.nextLine();
				String[] split2 = nextLine.split(",");
				array[index][0] = Integer.parseInt(split2[0]);
				array[index][1] = Integer.parseInt(split2[1]);
				length += Integer.parseInt(split2[2]);
				index++;
			}else{
				break;
			}
		}
		
		for(int i = 0; i < array.length; i++){
			
		}
	}
}

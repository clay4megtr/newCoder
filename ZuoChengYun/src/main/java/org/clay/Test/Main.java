package org.clay.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);

		String sourceStr = reader.nextLine(); // 第一行
		
		int cityNum;
		int waysNum;
		
		String source;
		String target;

		String[] split = sourceStr.split(" ");
		cityNum = Integer.parseInt(split[0]);
		waysNum = Integer.parseInt(split[1]);
		source = split[2];
		target = split[3];
		
		//int[][] graph = new int[cityNum-1][cityNum-1];  最短路径？？  .....这么难吗？
	
		String[][] graph = new String[waysNum][2];
		while(waysNum != 0){
			
			String line = reader.nextLine();
			String[] split2 = line.split(" ");
			int index = --waysNum;
			graph[index][0] = split2[0];
			graph[index][1] = split2[1];
		}
		
		List<String> next = new ArrayList<>();		//下一步可到达的节点

		int time = 0;	//转机次数
		
		for(int i = 0; i < waysNum; i++){
			if(source.equals(graph[i][0])){
				next.add(graph[i][1]);
			}
			
			if(source.equals(graph[i][1])){
				next.add(graph[i][0]);
			}
		}
		
		for (String string : next) {
			if(string.equals(target)){
				System.out.println(time);
			}
		}
		
		while(!next.isEmpty()){//开始往下继续查找
			
		}
 	}
}

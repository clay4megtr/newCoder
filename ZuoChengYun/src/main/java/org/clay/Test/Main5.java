package org.clay.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Main5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		
		int nums = sc.nextInt();
		
		List<HashSet<Integer>> list = new LinkedList<>();
		
		for(int i = 1; i <= nums; i++){
			int temp = sc.nextInt();
			boolean flag = false;
			
			for(HashSet ve : list){
				if(ve.contains(temp) || ve.contains(i)){
					flag = true;
					ve.add(i);
					ve.add(temp);
					break;
				}
			}
			
			if(!flag){
				HashSet<Integer> newVe = new HashSet<>();
				newVe.add(i);
				newVe.add(temp);
				list.add(newVe);
			}
		}
		
		System.out.println(list.size());
	}
	
}

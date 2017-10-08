package org.clay.Chap2;

/**
 * 合并两个有序数组A,B 且A的数组长度正好足够A+B之后 的长度
 * 从后往前合并即可
 * @author clay
 */
public class mergeAB {

	public void mergeAB(int[] A, int[] B, int lenA, int lenB){
		
		int lenAB = lenA + lenB - 1;
		int i = lenA-1;
		int j = lenB-1;
		
		while(i >= 0 && j >= 0){
			if(A[i] > B[j]){
				A[lenAB--] = A[i--];
			}else{
				A[lenAB--] = B[j--];
			}
		}
		
		while(j >= 0){
			A[lenAB--] = B[j--];
		}
	}
	
	public static void main(String[] args) {
		
		mergeAB mm = new mergeAB();
		
		int[] array1 = new int[6];
		array1[0] = 2;
		array1[1] = 4;
		array1[2] = 6;
		
		int[] array2 = new int[]{1,3,5};
		mm.mergeAB(array1, array2, 3, 3);
		
		for(int i = 0; i < array1.length; i++){
			System.out.println(array1[i]);
		}
	}
}

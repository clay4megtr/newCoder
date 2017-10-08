package org.clay.Chap2.sort;

/**
 * 希尔排序
 * @author clay
 */
public class HeerSort {

	
	public int[] heerSort(int[] array, int n){
	
		// gap为步长，每次减为原来的一半。
		for(int gap = n/2; gap > 0; gap = gap/2){
			
			// 共gap个组，对每一组都执行直接插入排序
			for(int i = 0; i < gap; i++){
				//所以这两个循环的作用就是分组
				/*[20, 10, 60, 40, 80, 30, 50, 70]
					gap=2
					20	50	60	80	
					10	30	40	70*/
				
				// 如果a[j] < a[j-gap]，则寻找a[j]位置，并将后面数据的位置都后移。-直接插入排序
				for(int j = i+gap; j < n; j++){
					
					if(array[i] < array[j-gap]){
						
						int temp = array[j];
						
						int k;
						for(k = j-gap; k >=0 && array[k] > temp; k = k-gap){
							
							array[k+gap] = array[k];
						}
						
						array[k+gap] = temp;
					}
				}
			}
		}
		
		return array;
	}
	
	public static void main(String[] args) {
		HeerSort hs = new HeerSort();
		int[] array = new int[] { 1, 4, 6, 9, 7, 5, 3 };
		int[] sort = hs.heerSort(array, array.length);
		for (int i = 0; i < sort.length; i++) {
			System.out.println(array[i]);
		}
	}
}

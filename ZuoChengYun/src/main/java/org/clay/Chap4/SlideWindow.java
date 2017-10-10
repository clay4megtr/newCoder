package org.clay.Chap4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 返回一个n-w+1 长度的数组， 每个元素代表每个窗口中的最大值。
 * @author clay
 */
public class SlideWindow {

	/**
	 * array：源数组 
	 * w：窗口大小 
	 * 时间复杂度O(N*w)
	 */
	public int[] moveWindow(int[] array, int w) {

		int[] result = new int[array.length - w + 1];

		for (int i = 0; (i + (w - 1)) < array.length; i++) {

			int[] newArr = Arrays.copyOfRange(array, i, i + w);
			Arrays.sort(newArr); // 左闭右开
			result[i] = newArr[w - 1];
		}
		return result;
	}
	/**
	 * 最优解: 时间复杂度为O(N)
	 * 利用双端队列
	 */
	public Integer[] moveWindow1(Integer[] arr,int n, int w) {
		
		if(w == 1){
			return arr;   //如果窗口大小为1， 直接返回数组即可
		}
		Deque<Integer> deq = new LinkedList<>();  //双端队列
		
		List<Integer> res = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            
        	//如果qmax为空，或者取出当前deque队尾存放的下标j 满足 arr[j] > array[i], 
        	//直接把下标i放进deque的队尾.
        	if(deq.isEmpty() || arr[deq.getLast()] > arr[i]){
        		deq.addLast(i);
        	}else{
        		//如果arr[j] <= array[i],则一直从deque的队尾弹出下标。
        		//直到某个下标在deque中对应的值大于arr[i]，就把i放入deque的队尾。
        		while(!deq.isEmpty() && arr[deq.getLast()] <= arr[i]){
        			deq.removeLast();
        		}
        		deq.addLast(i);
        	}
        	//如果deque队头的下标等于i-w，弹出deque当前队头下标.
        	if(deq.getFirst() == i-w){
        		deq.removeFirst();
        	}
        	//如果w窗口等于3的话，那么从i=2开始，产生的才是窗口的最大值。
        	if(i < w-1){
        		continue;
        	}
        	res.add(arr[deq.getFirst()]);
        } 
        return (Integer[])res.toArray(new Integer[n-w+1]);
	}

	public static void main(String[] args) {

		SlideWindow mw = new SlideWindow();
		Integer[] array = new Integer[] { 4, 5, 5, 4, 3, 3, 6, 7, 6,4,8,9,14};
		Integer[] window = mw.moveWindow1(array,array.length, 3);
		for (int i : window) {
			System.out.println(i);
		}
	}
}

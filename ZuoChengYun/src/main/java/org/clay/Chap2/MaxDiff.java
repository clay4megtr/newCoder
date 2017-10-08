package org.clay.Chap2;

/**
 * 一个数组，求排好序之后，相邻两数字的最大差值
 * 1,2,3,4,7,8,9    返回3
 * @author clay
 */
public class MaxDiff {

	/**
	 * 如果用排序法实现，其时间复杂度为O(NlogN)，而如果利用桶排序的思想（不是桶排序），可以做到O(N)，额外空间复杂度为O(N)。
	 * 遍历arr找到最大值max和最小值min。如果arr的长度为N，准备N+1个桶，把max单独放在第N+1个桶中，[min,max)范围上的数放在1~N号桶里，
	 * 对于1~N号桶中的每一个桶来说，负责的区间为(max-min)/N。如果一个数为num，它应该分配进(num-min)*len/(max-min)。
	 * 
	 * (max-min) / len  = 桶的间距
	 * 那么  (num-min) / ((max-min) / len) 就是num这个数字的桶号
	 * (num-min) / ((max-min) / len) = (num-min)*len/(max-min)
	 * 
	 * arr一共有N个数，旻、一定会放进1号桶中，max一定会放进最后的桶中，所以，如果把所有的数放进N+1个桶中，必然有桶是空的。
	 * 产生最大差值的相邻数来自不同桶。所以只要计算桶之间数的间距可以，也就是只用记录每个桶的最大值和最小值，
	 * 最大差值只可能来自某个非空桶的最小值减去前一个非空桶的最大值。
	 */
	public int findMaxDiff(int[] nums){
		
		if(nums == null || nums.length < 2){
			return 0;
		}
		
		int len = nums.length;
		int min = Integer.MAX_VALUE;
		int max=  Integer.MIN_VALUE;
		
		//先找到最大值和最小值
		for(int i = 0; i < len; i++){
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		
		if(min == max){
			return 0;
		}
		boolean[] hasNum = new boolean[len+1];	//判断这个桶里有没有数字
		int[] maxs = new int[len+1];			//这个桶里装的最大的数字
		int[] mins = new int[len+1];			//这个桶里装的最小的数字
		int bid = 0;	//桶号
		
		for(int i = 0; i < len; i++){
			bid = bucket(nums[i], len, min, max);	//这个计算桶号的时候就把9单独划分到最后一个桶了....
			mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
			maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
			hasNum[bid] = true;
		}
		
		for(int i = 0; i < mins.length; i++){
			System.out.println(mins[i]);
		}
		
		int res = 0;
		int lastMax = 0;
		int i = 0;
		
		while(i <= len){
			if(hasNum[i]){		  //找到第一个不为空的桶
				lastMax = maxs[i];//找到第一个不为空的桶内装的最大值
				break;
			}
		}
		
		for(; i <= len; i++){
			if(hasNum[i]){
				res = Math.max(res, mins[i] - lastMax);
				lastMax = maxs[i];
			}
		}
		return res;
	}
	
	private int bucket(long num, long len, long min, long max) {
		return (int)((num-min) * len / (max - min));
	}

	public static void main(String[] args) {
		MaxDiff md = new MaxDiff();
		int[] array = new int[]{1,2,3,4,7,8,9};
		md.findMaxDiff(array);
		//System.out.println();
	}
}

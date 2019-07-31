package org.clay.advanced_class_05;

public class Code_05_Max_EOR {

	public static int getMaxE1(int[] arr){
		int max = Integer.MIN_VALUE;
		//前两个循环枚举所有以i结尾的子数组
		for(int i = 0; i < arr.length; i++){  //每个位置以i结尾
			for(int start = 0; start <= i; start++){  //开头和结尾定义好了:0到i，1到i，2到i，等等
				int res = 0;
				//0到i的异或结果怎么求，从start到i再遍历一遍；
				for (int k = start; k <= i; k++){
					res ^= arr[k];
				}
				max = Math.max(max,res);
			}
		}
		return max;
	}

	/**
	 * E1^E2 = E3
	 * 则 E1^E3=E2，E2^E3=E1
	 */
	public static int getMaxE2(int[] arr){
		int max = Integer.MIN_VALUE;
		int[] dp = new int[arr.length];
		int eor = 0;
		//枚举所有以i结尾的子数组
		for(int i = 0; i < arr.length; i++){  //每个位置以i结尾
			eor ^= arr[i];  //0..i的异或值
			max = Math.max(max,eor);
			//0到i的结果有了，再处理1到i，2到i，。。。。
			for(int start = 1; start <= i; start++){  //开头和结尾定义好了；
				int curEor = eor ^ dp[start - 1];
				max = Math.max(max,curEor);
			}
			dp[i] = eor;
		}
		return max;
	}


	public static class Node {
		public Node[] nexts = new Node[2]; //0的路还是1的路
	}

	/**
	 * 加一个数还是选择一个数都是常数级别的；
	 */
	public static class NumTrie {
		public Node head = new Node();

		//把num对应的二进制提出来，加到前缀树，
		public void add(int num) {
			Node cur = head;
			// for循环就是依次往下建立节点，
			for (int move = 31; move >= 0; move--) {
				int path = ((num >> move) & 1);  //每次取出最高位，
				cur.nexts[path] = cur.nexts[path] == null ? new Node() : cur.nexts[path];
				cur = cur.nexts[path];
			}
		}

		/**
		 * @param num  从0到i的异或结果
		 * @return  最优结果，
		 */
		public int maxXor(int num) {
			Node cur = head;
			int res = 0;
			for (int move = 31; move >= 0; move--) {
				int path = (num >> move) & 1;  //从高位到低位依次提取出0和1
				//对于符号位，希望选的路和二进制最高位是一样的，这样异或出来的最高位就是0，代表正数
				//对于剩下的其他位，希望选的路和当前的二进制位数不一样，这样异或出来的当前位的二进制数就是1，大，
				int best = move == 31 ? path : (path ^ 1);	//期望选择的路
				best = cur.nexts[best] != null ? best : (best ^ 1); //实际选择的路
				res |= (path ^ best) << move;  //设置每一位的答案
				cur = cur.nexts[best]; //继续往下走
			}
			return res;
		}

	}

	public static int maxXorSubarray(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int eor = 0;
		NumTrie numTrie = new NumTrie(); //存放着之前所有从0到i-1的计算结果，
		numTrie.add(0);
		for (int i = 0; i < arr.length; i++) {
			eor ^= arr[i];  	//eor永远是从0到i的异或和；
			max = Math.max(max, numTrie.maxXor(eor));  //黑盒直接返回最大的
			numTrie.add(eor);
		}
		return max;
	}

	// for test
	public static int comparator(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int eor = 0;
			for (int j = i; j < arr.length; j++) {
				eor ^= arr[j];
				max = Math.max(max, eor);
			}
		}
		return max;
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 30;
		int maxValue = 50;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr = generateRandomArray(maxSize, maxValue);
			int res = maxXorSubarray(arr);
			int comp = comparator(arr);
			if (res != comp) {
				succeed = false;
				printArray(arr);
				System.out.println(res);
				System.out.println(comp);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}
}

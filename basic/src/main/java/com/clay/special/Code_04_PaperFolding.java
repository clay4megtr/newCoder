package com.clay.special;

public class Code_04_PaperFolding {

	public static void printAllFolds(int N) {
		printProcess(1, N, true);
	}

	/**
	 * @param i  第几层
	 * @param N  总共几层
	 * @param down  true表示下，false 表示上
	 */
	public static void printProcess(int i, int N, boolean down) {
		if (i > N) {
			return;
		}
		printProcess(i + 1, N, true);
		System.out.println(down ? "down " : "up ");
		printProcess(i + 1, N, false);
	}

	public static void main(String[] args) {
		int N = 4;
		printAllFolds(N);
	}
}

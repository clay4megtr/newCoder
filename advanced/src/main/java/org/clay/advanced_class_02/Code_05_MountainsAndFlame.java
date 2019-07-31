package org.clay.advanced_class_02;

import java.util.Scanner;
import java.util.Stack;

public class Code_05_MountainsAndFlame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int size = in.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(communications(arr));
        }
        in.close();
    }

    public static int nextIndex(int size, int i) {
        return i < (size - 1) ? (i + 1) : 0;
    }

    //相邻相同山峰之间的对数，若只有一个，则没有成对，若有两个以上计算内部成对数,Cn:2+1*n 公式
    public static long getInternalSum(int n) {
        return n == 1L ? 0L : (long) n * (long) (n - 1) / 2L;
    }

    public static class Pair {
        public int value; //当前数
        public int times; //出现的次数

        public Pair(int value) {
            this.value = value;
            this.times = 1;
        }
    }

    public static long communications(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int size = arr.length;
        int maxIndex = 0;
        for (int i = 0; i < size; i++) {
            maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;//找到最高山峰的位置
        }
        int value = arr[maxIndex];//最高山峰的高度
        int index = nextIndex(size, maxIndex);//最高山峰的下一个位置
        long res = 0L;
        Stack<Pair> stack = new Stack<Pair>();
        stack.push(new Pair(value));  //先把最大值扔进去
        while (index != maxIndex) {
            value = arr[index];//当前值
            while (!stack.isEmpty() && stack.peek().value < value) {//单调栈，出栈操作；
                int times = stack.pop().times;
//                res += getInternalSum(times) + times;
//                res += stack.isEmpty() ? 0 : times;
                res += getInternalSum(times) + times * 2;//因为栈底是最大元素，所以在此阶段不可能跳出
            }
            if (!stack.isEmpty() && stack.peek().value == value) {
                stack.peek().times++;
            } else {
                stack.push(new Pair(value));
            }
            index = nextIndex(size, index);
        }
        while (!stack.isEmpty()) {
            int times = stack.pop().times;
            res += getInternalSum(times); //每次一定会弹出一个Cn:2
            if (!stack.isEmpty()) {
                res += times;
                if (stack.size() > 1) {//当栈底还剩大于1个的时候，弹出的那个数还可以与栈底的数成为对数
                    res += times;
                } else {
                    res += stack.peek().times > 1 ? times : 0;
                }
            }
        }
        return res;
    }
}

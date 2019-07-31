package org.clay.advanced_class_02;

import java.util.Stack;

public class Code_04_MaximalRectangle {
    // 求最大子矩形
    public static int maxRecSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];  //有多少列，就形成多大长度
        for (int i = 0; i < map.length; i++) {//枚举以i行打底
            for (int j = 0; j < map[0].length; j++) {//生成i行打底的直方图数组
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxRecFromBottom(height), maxArea); //每一行算一次；
        }
        return maxArea;
    }

    /**
     * 求直方图的最大矩形面积
     * example [4,3,2,5,6]
     */
    private static int maxRecFromBottom(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();  //单调栈
        for (int i = 0; i < height.length; i++) { // 遍历每一个数
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {  //当前数小于等于栈顶的位置；
                int j = stack.pop(); //弹出，结算
                int k = stack.isEmpty() ? -1 : stack.peek(); //k: 左边界，栈为空，左边界就是-1，否则就是弹出之后的栈顶
                int curArea = (i - k - 1) * height[j]; //x是当前数index，它让j出栈了，x就是j的右边界，k是j的左边界，j是出栈的数，也是被结算的数
                                                    //(i - k - 1) 就是底的长度；也就是向两边延伸的距离
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);//当前数进栈，
        }
        while (!stack.isEmpty()) {  //栈中剩下的东西，结算
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] map = {{1, 0, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 0}};
        System.out.println(maxRecSize(map));
    }
}

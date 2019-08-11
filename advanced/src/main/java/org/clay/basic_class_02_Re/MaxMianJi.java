package org.clay.basic_class_02_Re;

import java.util.Stack;

/**
 * 直方图中矩形的最大面积
 * 单调栈
 */
public class MaxMianJi {

    public static int get(int[] arr){

        int max = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++){

            if (stack.isEmpty() || arr[i] > arr[stack.peek()]){
                stack.push(i);
            }else{      //小于栈顶元素
                while(!stack.isEmpty()){
                    if(arr[i] < arr[stack.peek()]){
                        int cur = stack.pop();
                        int left = stack.isEmpty() ? -1 : stack.peek();
                        max = Math.max((i - left - 1) * arr[cur],max);
                    }else{
                        break;
                    }
                }
                stack.push(i);
            }
        }

        int index = arr.length;
        while(!stack.isEmpty()){
            int cur = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            max = Math.max((index - left - 1) * arr[cur],max);
        }

        return max;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{3,2,3,0};
        System.out.println(get(arr));
    }
}

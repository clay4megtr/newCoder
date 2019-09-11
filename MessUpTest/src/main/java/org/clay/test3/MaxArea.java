package org.clay.test3;

import java.util.Stack;

public class MaxArea {


    public static int getMaxArea(int[] arr){

        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){

            if(stack.isEmpty() || arr[stack.peek()] < arr[i]){
                stack.push(i);
            }else{
                int index = stack.pop();
                if(stack.isEmpty()){
                    int area = (i - (-1) - 1) * arr[index];
                    max = Math.max(area,max);
                    stack.push(i);
                }else{
                    while(!stack.isEmpty()){
                        int area = (i - stack.peek() - 1) * arr[index];
                        max = Math.max(max,area);
                        if(arr[stack.peek()] < arr[i]){
                            break;
                        }else{
                            index = stack.pop();
                        }
                    }
                    stack.push(i);
                }
            }
        }

        while(!stack.isEmpty()){
            int index = stack.pop();

            Integer but = stack.isEmpty() ? null : stack.peek();
            if(but != null){
                int area = (arr.length-but-1) * arr[index];
                max = Math.max(area,max);
            }else{
                int area = (arr.length-(-1)-1) * arr[index];
                max = Math.max(area,max);
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,3,5,2};

        System.out.println(getMaxArea(arr));
    }
}

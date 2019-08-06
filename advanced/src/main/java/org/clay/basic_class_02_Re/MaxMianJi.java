package org.clay.basic_class_02_Re;

import java.util.Stack;

public class MaxMianJi {

    public static int get(int[] arr){

        int max = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++){

            if (stack.isEmpty() || arr[i] > arr[stack.peek()]){
                stack.push(i);
            }else{ //小于栈顶元素
                while(!stack.isEmpty()){
                    if(arr[i] < arr[stack.peek()]){
                        int cur = stack.pop();
                        max = Math.max((i - cur) * arr[cur],max);
                    }else{
                        break;
                    }
                }
                stack.push(i);
            }
        }

        int index = 0;
        while(!stack.isEmpty()){
            max = Math.max(arr[stack.pop()] * ++index,max);
        }

        return max;
    }
}

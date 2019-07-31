package org.clay.test1;

import java.util.Stack;

public class ReverseStack {

    public static void reverse(Stack<Integer> stack){

        if(stack.isEmpty()){
            return;
        }else{
            int i = getAndRemoveLast(stack);
            reverse(stack);
            stack.push(i);
        }
    }

    public static Integer getAndRemoveLast(Stack<Integer> stack){

        if(stack.size() == 1){
            return stack.pop();
        }else{
            int i = stack.pop();
            int last = getAndRemoveLast(stack);
            stack.push(i);
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}

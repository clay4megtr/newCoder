package org.clay.classEight_Re;

import java.util.Stack;

public class ReverseStackUsingRecursive {


    public static Integer g(Stack<Integer> stack){

        Integer cur = stack.pop();

        if (!stack.isEmpty()){
            Integer last =  g(stack);
            stack.push(cur);
            return last;
        }else{
            return cur;
        }
    }

    public static void reverse(Stack<Integer> stack){

        Integer last = g(stack);

        if(!stack.isEmpty()){
            reverse(stack);
        }

        stack.push(last);
    }

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        reverse(test);
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }
    }
}

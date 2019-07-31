package org.clay.test1;

import java.util.Stack;

public class Stack2Queue {

    public Stack<Integer> pushStack = new Stack();
    public Stack<Integer> popStack = new Stack();

    public void push(int x){
        pushStack.push(x);
    }

    public Integer poll(){

        if(pushStack.isEmpty() && popStack.isEmpty()){
            throw new RuntimeException("queue is empty");
        }

        if(popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }

        return popStack.pop();
    }
}

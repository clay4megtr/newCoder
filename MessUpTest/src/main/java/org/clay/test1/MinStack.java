package org.clay.test1;

import java.util.Stack;

public class MinStack {

    public Stack<Integer> dataStack = new Stack();
    public Stack<Integer> minStack = new Stack();

    public void push(int x){

        if(minStack.isEmpty()){
            minStack.push(x);
        }else if(x < this.getMin()){
            minStack.push(x);
        }else{
            int min = this.getMin();
            minStack.push(min);
        }
        dataStack.push(x);
    }

    public Integer pop(){
        if (this.dataStack.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        minStack.pop();
        return dataStack.pop();
    }

    public Integer getMin(){
        if(minStack.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        return minStack.peek();
    }
}
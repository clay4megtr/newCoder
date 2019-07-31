package org.clay.classThree_Re_1;

import java.util.Stack;

public class getMinStack {

    public static class MyStack {
        private Stack<Integer> dataStack;
        private Stack<Integer> getMinStack;

        private void push(Integer x){
            dataStack.push(x);
            if(getMinStack.isEmpty()){
                getMinStack.push(x);
            }else{
                if(x < getMinStack.peek()){
                    getMinStack.push(x);
                }else{
                    getMinStack.push(getMinStack.peek());
                }
            }
        }

        private Integer pop(){
            this.getMinStack.pop();
            return dataStack.pop();
        }

        private Integer getMin(){
            return getMinStack.peek();
        }
    }
}

package org.clay.classThree_Re_1;

import java.util.Stack;

public class getMinStack {

    public static class MyStack {

        private Stack<Integer> dataStack = new Stack();
        private Stack<Integer> getMinStack = new Stack();


        private void push(int element){
            dataStack.push(element);
            if(getMinStack.isEmpty()){
                getMinStack.push(element);
            }else{
                if(element > getMinStack.peek()){
                    getMinStack.push(getMinStack.peek());
                }else{
                    getMinStack.push(element);
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

package org.clay.classThree_Re_1;

import java.util.Stack;

public class getMinStack {

    public static class MyStack {

        private Stack<Integer> dataStack = new Stack();
        private Stack<Integer> getMinStack = new Stack();


        private void push(int element){
            if(getMinStack.empty()){
                getMinStack.push(element);
            }else{
                int tmp = getMinStack.peek();
                if(tmp > element){
                    getMinStack.push(element);
                }else{
                    getMinStack.push(tmp);
                }
            }

            dataStack.push(element);
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

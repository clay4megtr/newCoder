package org.clay.classThree_Re_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueueConvert {

    /**
     * 两个栈实现队列
     */
    public static class TwoStacksQueue {
        private Stack<Integer> data1;
        private Stack<Integer> data2;

        public TwoStacksQueue(){
            data1 = new Stack<Integer>();
            data2 = new Stack<Integer>();
        }

        public void push(int element){
            data1.push(element);
        }

        public Integer pop(){
            if(data2.isEmpty() && data1.isEmpty()){
                throw new RuntimeException("没有元素");
            }

            if(data2.isEmpty()){
                while(!data1.isEmpty()){
                    data2.push(data1.pop());
                }
            }
            return data2.pop();
        }
    }

    /**
     * 两个队列实现栈
     */
    public static class TwoQueuesStack {

        private Queue<Integer> data = new LinkedList<Integer>();
        private Queue<Integer> help = new LinkedList<Integer>();


        public void push(int element){
            data.add(element);
        }

        public Integer poll(){
            if(data.size() == 0){
                throw new RuntimeException("没有元素");
            }

            while(data.size() != 1){
                help.add(data.poll());
            }
            int res = data.poll();
            Queue<Integer> temp = data;
            data = help;
            help = temp;

            return res;
        }
    }
}

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
            if(data1.empty() && data2.empty()){
                throw new RuntimeException("empty");
            }else{
                if(data2.empty()){
                    while (!data1.empty()){
                        data2.push(data1.pop());
                    }
                    return data2.pop();
                }else{
                    return data2.pop();
                }
            }

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
            if(data.isEmpty()){
                throw new RuntimeException("empty");
            }
            while(data.size() != 1){
                int tmp = data.poll();
                help.add(tmp);
            }
            int res = data.poll();

            Queue<Integer> t = data;
            data = help;
            help = t;

            return res;
        }
    }
}

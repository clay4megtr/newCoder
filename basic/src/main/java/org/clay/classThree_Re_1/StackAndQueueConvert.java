package org.clay.classThree_Re_1;

import java.util.Queue;
import java.util.Stack;

public class StackAndQueueConvert {

    public static class TwoStacksQueue {

        private Stack<Integer> s1 = new Stack<Integer>();
        private Stack<Integer> s2 = new Stack<Integer>();

        private void add(Integer x){
            s1.push(x);
        }
        private Integer poll(){
            if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }
    }

    /**
     * 两个队列实现栈
     */
    public static class TwoQueuesStack {
        private Queue<Integer> data;
        private Queue<Integer> help;

        private void push(Integer x){
            data.add(x);
        }

        private Integer pop(Integer x){

            while(data.size() > 1){
                help.add(data.poll());
            }
            Integer res = data.poll();

            Queue<Integer> temp = data;
            data = help;
            help = temp;

            return res;
        }

    }
}

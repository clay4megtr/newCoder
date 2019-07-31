package org.clay.classThree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code_03_StackAndQueueConvert {

    /**
     *  两个栈实现队列
     */
    public static class TwoStacksQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        public void push(int pushInt) {
            stackPush.push(pushInt);
        }

        public Integer poll(){

            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }else if(stackPop.isEmpty()){//第一个限制条件：Pop栈一定为空时才能倒。
                while(!stackPush.isEmpty()){//第二个限制条件：只要倒，就一定要倒完。
                    stackPop.push(stackPush.pop());//从stackPush倒数据到stackPop。
                }
            }
            return stackPop.pop();//返回pop栈的第一个。
        }
    }


    /**
     * 两个队列实现栈
     */
    public static class TwoQueuesStack {
        private Queue<Integer> data;
        private Queue<Integer> help;

        public TwoQueuesStack() {
            data = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public void push(Integer x){
            data.add(x);
        }

        public Integer poll(){
            if (data.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }

            while(data.size() > 1){
                help.add(data.poll());//之前的全部放到help队列中，只剩最后一个
            }
            int res = data.poll();//最后一个要取的就是结果
            swap();
            return res;
        }

        /**
         * 交换两个队列的引用
         * 使得下次poll取数据的时候，还是从data队列中取，然后把除最后一个以外的都放到help队列。
         */
        private void swap() {
            Queue<Integer> tmp = help;
            help = data;
            data = tmp;
        }
    }
}

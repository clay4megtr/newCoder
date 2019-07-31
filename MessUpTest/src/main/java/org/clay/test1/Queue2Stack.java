package org.clay.test1;

import java.util.LinkedList;
import java.util.Queue;

public class Queue2Stack {

    private Queue<Integer> dataQueue = new LinkedList();
    private Queue<Integer> helpQueue = new LinkedList();

    public void push(int x){

        this.dataQueue.add(x);
    }

    public Integer pop(){
        if(dataQueue.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        while(dataQueue.size() > 1){
            helpQueue.add(dataQueue.poll());
        }
        int res = dataQueue.poll();

        Queue<Integer> tmpQueue = dataQueue;
        dataQueue = helpQueue;
        helpQueue = dataQueue;

        return res;
    }
}

package org.clay.test1;

import java.util.PriorityQueue;

public class LessMoney {

    public static int lessMoney(int[] arr){

        PriorityQueue<Integer> queue = new PriorityQueue();
        for(int i = 0; i < arr.length; i++){
            queue.add(arr[i]);
        }

        int sum = 0;

        while(queue.size() > 1){
            int temp = queue.poll() + queue.poll();
            sum += temp;
            queue.add(sum);
        }

        return sum;
    }
}

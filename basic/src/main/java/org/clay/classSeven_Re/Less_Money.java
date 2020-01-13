package org.clay.classSeven_Re;

import java.util.PriorityQueue;

public class Less_Money {

    public static int lessMoney(int[] arr){

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(Integer num: arr){
            queue.add(num);
        }

        int sum = 0;
        while(queue.size() > 1){
            int res = queue.poll() + queue.poll();
            sum += res;
            queue.add(res);
        }

        return sum;
    }

    public static void main(String[] args) {

        //solution
        int[] arr = {10,20,30};
        System.out.println(lessMoney(arr));
    }
}

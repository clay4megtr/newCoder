package org.clay.classSeven_Re;

import java.util.PriorityQueue;

public class Less_Money {

    public static int lessMoney(int[] arr){

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++){
            pq.add(arr[i]);
        }

        int sum = 0;
        int cur = 0;

        while(pq.size() > 1){
            cur = pq.poll() + pq.poll();
            sum += cur;
            pq.add(cur);
        }
        return sum;
    }

    public static void main(String[] args) {

        // solution
        int[] arr = {10,20,30};
        System.out.println(lessMoney(arr));

    }
}

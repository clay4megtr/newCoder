package org.clay.test1;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {

    /**
     * Node就是项目
     */
    public static class Node {
        public int p;//收益
        public int c;//花费

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }
    /**
     * 小根堆，谁花费低，谁放在顶部
     */
    public static class MinCostComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }

    }

    /**
     * 大根堆，谁收益高，谁放在顶部
     */
    public static class MaxProfitComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }

    }

    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Node[] nodes = new Node[Profits.length];
        for (int i = 0; i < Profits.length; i++) {
            nodes[i] = new Node(Profits[i], Capital[i]);
        }

        PriorityQueue<Node> minCost = new PriorityQueue(new MinCostComparator());
        PriorityQueue<Node> maxProfit = new PriorityQueue(new MaxProfitComparator());

        for(int i = 0; i < k; i++){
            while(!minCost.isEmpty() && minCost.peek().c <= W){
                maxProfit.add(minCost.poll());
            }

            if(minCost.isEmpty()){
                return W;
            }
            W += maxProfit.poll().p;
        }
        return W;
    }
}

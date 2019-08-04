package org.clay.classSeven_Re;

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

    public static int findMaximizedCapital(int k,int W,int[] Profits, int[] Capital){
        Node[] nodes = new Node[Profits.length];
        for (int i = 0; i < Profits.length; i++) {
            nodes[i] = new Node(Profits[i], Capital[i]);
        }

        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());//最小花费
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());//最大收益

        for (int i = 0; i < nodes.length; i++) {
            minCostQ.add(nodes[i]);     //把所有的项目加到小根堆中去。
        }

        for(int i = 0; i < k; i++){  //依次做项目，最多做k个

            while(!minCostQ.isEmpty() && minCostQ.peek().c <= W ){
                maxProfitQ.add(minCostQ.poll());
            }

            if (maxProfitQ.isEmpty()) {//很可能做不到k个项目就得停止，因为初始资金做不了项目了，
                return W;
            }
            W += maxProfitQ.poll().p;
        }
        return W;
    }
}

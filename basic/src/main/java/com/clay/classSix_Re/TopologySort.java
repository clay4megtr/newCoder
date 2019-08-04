package com.clay.classSix_Re;

import java.util.*;

/**
 * 要求: 有向图，且一定要有入度为0的节点，且没有环
 */
public class TopologySort {

    public static void topologySort(Graph graph){

        HashMap<Node,Integer> inMap = new HashMap<>();

        Queue<Node> zeroInQueue = new LinkedList<>();

        for(Node node: graph.nodes.values()){
            inMap.put(node,node.in);
            if(node.in == 0){
                zeroInQueue.offer(node);
            }
        }

        List<Node> result = new ArrayList<>();

        while(!zeroInQueue.isEmpty()){
            Node cur = zeroInQueue.poll();
            result.add(cur);

            for(Node next: cur.nexts){
                inMap.put(next,next.in-1);
                if(inMap.get(next) == 0){
                    zeroInQueue.offer(next);
                }
            }
        }
    }
}

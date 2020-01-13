package com.clay.classSix_Re;

import java.util.*;

/**
 * 要求: 有向图，且一定要有入度为0的节点，且没有环
 */
public class TopologySort {

    public static void topologySort(Graph graph){

        HashMap<Node,Integer> map = new HashMap<>();  //key是具体Node，value是入度

        Queue<Node> queue = new LinkedList<>();

        for(Node node: graph.nodes.values()){
            map.put(node,node.in);
            if(node.in == 0){
                queue.offer(node);
            }
        }

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value);

            for(Node next: cur.nexts){ //后续节点的入度就要减1
                map.put(next,map.get(next)-1);
                if(map.get(next) == 0){
                    queue.offer(next);
                }
            }
        }
    }
}

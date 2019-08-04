package com.clay.classSix_Re;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void bfs(Node node){

        if(node == null){
            return;
        }

        Queue<Node> queue = new LinkedList();
        HashSet<Node> set = new HashSet<>();
        queue.offer(node);
        set.add(node);

        while(!queue.isEmpty()){
            node = queue.poll();
            System.out.println(node.value);

            for(Node next: node.nexts){
                if(!set.contains(next)){
                    set.add(node);
                    queue.offer(node);
                }
            }
        }
    }
}

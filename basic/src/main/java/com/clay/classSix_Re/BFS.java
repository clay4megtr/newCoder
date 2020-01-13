package com.clay.classSix_Re;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void bfs(Node node){

        if(node == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.offer(node);
        set.add(node);

        while(!queue.isEmpty()){
            Node cur = queue.poll();

            System.out.println(cur.value);
            for(Node tmp: cur.nexts){
                if(!set.contains(tmp)){
                    set.add(tmp);
                    queue.add(tmp);
                }
            }
        }
    }
}

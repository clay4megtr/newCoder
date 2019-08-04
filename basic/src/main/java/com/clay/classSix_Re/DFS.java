package com.clay.classSix_Re;

import java.util.HashSet;
import java.util.Stack;

public class DFS {

    public static void dfs(Node head){

        if(head == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.push(head);
        System.out.println(head.value);

        set.add(head);

        while(!stack.isEmpty()){
            Node node = stack.pop();
            for(Node next: node.nexts){
                if(!set.contains(next)){
                    stack.push(node);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}

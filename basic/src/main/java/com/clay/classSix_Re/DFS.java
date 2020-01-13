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
        set.add(head);
        System.out.println(head.value);

        while(!stack.isEmpty()){
            Node cur = stack.pop();

            for(Node next: cur.nexts){
                if(!set.contains(next)){
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}

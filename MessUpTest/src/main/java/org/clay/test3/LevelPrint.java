package org.clay.test3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 层序打印，并换行
 * 蛇形打印，并换行
 */
public class LevelPrint {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void print1(Node head){

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        Node last = head;
        Node nLast = head;

        while(!queue.isEmpty()){

            Node cur = queue.poll();
            System.out.println(cur.value);

            if(cur.left != null){
                queue.add(cur.left);
                nLast = cur.left;
            }
            if(cur.right != null){
                queue.add(cur.right);
                nLast = cur.right;
            }

            if(cur == last){
                last = nLast;
                System.out.println();
            }
        }
    }
}

package org.clay.Book_Re_LinkedList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * BST -> 链表
 */
public class Tree2List {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 方法一，
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     */
    public static Node process(Node head){

        Queue<Node> queue = new LinkedList<>();
        inOrder2Queue(head,queue);

        if(queue.isEmpty()){
            return head;
        }

        head = queue.poll();
        Node pre = head;
        pre.left = null;
        Node cur = null;

        while(!queue.isEmpty()){
            cur = queue.poll();  //弹出的节点
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;

        return head;
    }


    public static void inOrder2Queue(Node head, Queue<Node> queue){

        if(head == null){
            return;
        }
        inOrder2Queue(head.left,queue);
        queue.offer(head);
        inOrder2Queue(head.right,queue);
    }

    /**
     * 方法二，
     * 时间复杂度O(N)
     * 空间复杂度O(h) h为二叉树高度
     */



    public static void main(String[] args) {

        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);

        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        Node head = process(node);

        while(head != null){
            System.out.println(head.value);
            head = head.right;
        }
    }
}
package org.clay.basic_class_02_Re;

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

    public static void process(Node head){

        Stack<Node> stack = new Stack<>();

        while(!stack.isEmpty() || head != null){
            if(head != null){
                stack.push(head);
                head = head.left;
            }else{
                Node cur = stack.pop();

                cur.left = null;
                if(stack.peek() != null){
                    cur.right = stack.peek();
                    stack.peek().left = cur;
                }
                System.out.println(cur.value);

                head = cur.right;
            }
        }
    }

    public static void main(String[] args) {

        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);

        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        process(node);

        /*while(node.left != null){
            node = node.left;
        }
        Node head = node;

        System.out.println(head.value);*/
    }
}
package org.clay.test3;

import java.util.Stack;

public class TreePrint {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void pre(Node head){

        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.value);

            if(cur.right != null){
                stack.push(cur.right);
            }

            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    public static void mid(Node head){

        Stack<Node> stack = new Stack<>();

        while(head != null || !stack.isEmpty()){
            if(head != null){
                stack.push(head);
                head = head.left;
            }else{
                Node cur = stack.pop();
                System.out.println(cur.value);
                head = cur.right;
            }
        }
    }

    public static void last(Node head){

        Stack<Node> stack = new Stack<>();
        Stack<Node> newStack = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            newStack.push(cur);

            if(cur.left != null){
                stack.push(cur.left);
            }
            if(cur.right != null){
                stack.push(cur.right);
            }
        }
    }
}

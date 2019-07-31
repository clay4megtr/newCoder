package org.clay.test1;

import org.omg.CORBA.INTERNAL;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Stack;

public class IsSearchTree {

    public static class Node{
        private int val;
        private Node left;
        private Node right;

        public Node(int val){
            this.val = val;
        }
    }

    public static boolean isSearchTree(Node head){

        int pre = Integer.MIN_VALUE;
        Stack<Node> stack = new Stack<>();

        while(!stack.isEmpty() || head != null){

            if(head != null){
                stack.push(head);
                head = head.left;
            }else{
                Node node = stack.pop();
                if(node.val >= pre){
                    pre = node.val;
                }else{
                    return false;
                }
                head = node.right;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(1);
        head.left.right = new Node(6);
        head.right.left = new Node(5);
        head.right.right = new Node(7);

        System.out.println(isSearchTree(head));
    }
}

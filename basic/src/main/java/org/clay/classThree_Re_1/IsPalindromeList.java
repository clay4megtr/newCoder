package org.clay.classThree_Re_1;

import java.util.Stack;

public class IsPalindromeList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isPali1(Node root){
        Stack<Node> stack = new Stack<Node>();

        Node head = root;

        while (root != null){
            stack.push(root);
            root = root.next;
        }

        boolean res = true;
        while(!stack.isEmpty()){
            if(stack.pop().value != head.value){
                res = false;
            }
            head = head.next;
        }
        return res;
    }

    public static boolean isPali12(Node head){

        Node slow = head.next;
        Node quick = head;

        while(quick.next != null && quick.next.next != null){
            slow = slow.next;
            quick = quick.next.next;
        }

        Stack<Node> stack = new Stack<Node>();

        while(slow != null){
            stack.push(slow);
            slow = slow.next;
        }

        while(!stack.isEmpty()){

            if(stack.pop().value != head.value){
                return false;
            }
        }
        return true;
    }
}

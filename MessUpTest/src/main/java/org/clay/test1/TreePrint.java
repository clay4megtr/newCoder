package org.clay.test1;

import java.util.Stack;

public class TreePrint {

    public static class Node{
        private int val;
        private Node left;
        private Node right;

        public Node(int val){
            this.val = val;
        }
    }

    public static void prePrint(Node head){

        Stack<Node> stack = new Stack<>();
        stack.push(head);

        while (!stack.isEmpty()){

            Node res = stack.pop();
            System.out.println(res.val);
            if(head.right != null){
                stack.push(head.right);
            }
            if(head.left != null){
                stack.push(head.left);
            }
        }
    }

    public static void inPrint(Node head){

        Stack<Node> stack = new Stack<>();

        while (! stack.isEmpty() || head != null){

            if(head != null){
                stack.push(head);
                head = head.left;
            }else{
                Node gg = stack.pop();
                System.out.println(gg.val);
                head = head.right;
            }
        }
    }

    public static void postPrint(Node head){

        Stack<Node> stack = new Stack<>();
        stack.push(head);

        Stack<Node> resStack = new Stack<>();

        while (!stack.isEmpty()){

            Node res = stack.pop();
            resStack.push(res);

            if(head.left != null){
                stack.push(head.left);
            }
            if(head.right != null){
                stack.push(head.right);
            }
        }

        while(!resStack.isEmpty()){
            Node res = resStack.pop();
            System.out.println(res.val);
        }
    }
}

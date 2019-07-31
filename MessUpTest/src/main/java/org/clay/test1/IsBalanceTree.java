package org.clay.test1;

import java.util.Map;

public class IsBalanceTree {

    public static class Node{
        private int val;
        private Node left;
        private Node right;

        public Node(int val){
            this.val = val;
        }
    }

    public static class Struct{

        private boolean is;
        private int high;

        public Struct(boolean is,int high){
            this.is = is;
            this.high = high;
        }
    }

    public static Struct isBalance(Node head){

        if(head == null){
            return new Struct(true,0);
        }

        Struct leftS = isBalance(head.left);
        if(!leftS.is){
            return new Struct(false,0);
        }

        Struct rightS = isBalance(head.right);
        if(!rightS.is){
            return new Struct(false,0);
        }

        boolean iss = Math.abs(leftS.high - rightS.high) <= 1;

        return new Struct(iss, Math.max(leftS.high,rightS.high)+1);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.left.left = new Node(8);
        head.left.left.left.left = new Node(9);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isBalance(head).is);
    }
}

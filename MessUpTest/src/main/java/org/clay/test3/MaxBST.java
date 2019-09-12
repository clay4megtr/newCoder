package org.clay.test3;

import sun.reflect.generics.tree.ReturnType;

public class MaxBST {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class ReturnType{
        private int size;
        private Node head;
        private int max;
        private int min;

        public ReturnType(int size,Node head,int max,int min){
            this.size = size;
            this.head = head;
            this.max = max;
            this.min = min;
        }
    }

    public ReturnType process(Node head){

        if(head == null){
            return new ReturnType(0,null,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }

        ReturnType left_res = process(head.left);
        ReturnType right_res = process(head.right);

        if(left_res.max < head.value && right_res.min > head.value && head.left == left_res.head && head.right == right_res.head){
            return new ReturnType(left_res.size + 1 + right_res.size,head,Math.max(Math.max(left_res.max,right_res.max),head.value),Math.min(Math.min(left_res.min,right_res.min),head.value));
        }

        Node maxHead = left_res.size > right_res.size ? left_res.head : right_res.head;

        int maxSize = Math.max(left_res.size, right_res.size);

        return new ReturnType(maxSize,
                maxHead,
                Math.max(Math.max(left_res.max,right_res.max),head.value),
                Math.min(Math.min(left_res.min,right_res.min),head.value));
    }
}

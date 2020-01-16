package org.clay.basic_class_02_Re;

/**
 * 给定一个head节点，求整棵树的最大二叉搜索子树
 */
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
        private int size; //最大二叉搜索子树大小
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

        Node left = head.left;
        ReturnType leftRes = process(head.left);

        Node right = head.right;
        ReturnType rightRes = process(head.right);

        int includeItSelf = 0;
        if(left == leftRes.head && right == rightRes.head && head.value > leftRes.max && head.value < rightRes.min){
            includeItSelf = leftRes.size + rightRes.size + 1;
        }

        int p1 = leftRes.size;
        int p2 = rightRes.size;

        int maxSize = Math.max(Math.max(p1,p2),includeItSelf);

        Node maxHead = p1 > p2 ? leftRes.head : rightRes.head;
        if(maxSize == includeItSelf){
            maxHead = head;
        }
        return new ReturnType(maxSize,maxHead,Math.max(Math.max(leftRes.max,rightRes.max),head.value),Math.min(Math.min(leftRes.min,rightRes.min),head.value));
    }


    public static class ReturnType1{
        private int height;
        private boolean is_balance;

        public ReturnType1(int height,boolean is_balance){
            this.height = height;
            this.is_balance = is_balance;
        }
    }

    public ReturnType1 process1(Node head){

        if(head == null){
            return new ReturnType1(0,true);
        }

        ReturnType1 left_res = process1(head.left);
        ReturnType1 right_res = process1(head.right);

        if(!left_res.is_balance || !right_res.is_balance){
            return new ReturnType1(-1,false);
        }

        if(Math.abs(left_res.height - right_res.height) > 1){
            return new ReturnType1(-1,false);
        }

        return new ReturnType1(Math.max(left_res.height,right_res.height) + 1,true);
    }

}
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

    /**
     * 返回结构
     * 1.最大二叉搜索子树的大小
     * 2.最大二叉搜索子树的头部
     * 3.最大值
     * 4.最小值
     */
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
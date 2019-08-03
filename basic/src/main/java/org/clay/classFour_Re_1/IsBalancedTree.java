package org.clay.classFour_Re_1;

public class IsBalancedTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class ReturnData{
        private boolean isB;
        private int h;

        public ReturnData(boolean isB,int h){
            this.h = h;
            this.isB = isB;
        }
    }

    //===========第一种方法============================
    public static boolean isB(Node head) {
        return process(head).isB;
    }

    private static ReturnData process(Node head) {
        if(head == null){
            return new ReturnData(true,0);
        }

        ReturnData left = process(head.left);
        ReturnData right = process(head.right);

        if(!left.isB || !right.isB){
            return new ReturnData(false,left.h);
        }

        if(Math.abs(left.h - right.h) > 1){
            return new ReturnData(false,left.h);
        }

        return new ReturnData(true,Math.max(left.h,right.h) + 1);
    }


    //===============第二种方法=================================
    public static boolean isBalance(Node head) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head, 1, res);
        return res[0];
    }

    public static int getHeight(Node head, int level, boolean[] res) {
        if (head == null) {
            return level;
        }
        int lH = getHeight(head.left, level + 1, res);
        if (!res[0]) {
            return level;
        }
        int rH = getHeight(head.right, level + 1, res);
        if (!res[0]) {
            return level;
        }
        if (Math.abs(lH - rH) > 1) {
            res[0] = false;
        }
        return Math.max(lH, rH);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.left.left.left = new Node(6);
        //head.right.right = new Node(7);

        System.out.println(isB(head));
    }
}
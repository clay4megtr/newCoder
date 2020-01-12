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

    public static class DataStruct{

        public boolean isBal;
        public Integer height;

        public DataStruct(boolean isBal,Integer height){
            this.height = height;
            this.isBal = isBal;
        }
    }

    public static DataStruct process(Node head){

        if(head == null){
            return new DataStruct(true,0);
        }

        DataStruct leftRes = process(head.left);
        if(!leftRes.isBal){
            return new DataStruct(false,leftRes.height+1);
        }

        DataStruct rightRes = process(head.right);
        if(!rightRes.isBal){
            return new DataStruct(false,rightRes.height+1);
        }

        if(Math.abs(leftRes.height - rightRes.height) > 1){
            return new DataStruct(false,Math.max(leftRes.height,rightRes.height)+1);
        }

        return new DataStruct(true,Math.max(leftRes.height,rightRes.height)+1);
    }

    public static boolean isB(Node head) {
        return process(head).isBal;
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
package org.clay.basic_class_02_Re;

public class TreeMaxInstance {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class ReturnType{
        public int max_instance;
        public int h;

        public ReturnType(int max_instance,int h){
            this.max_instance = max_instance;
            this.h = h;
        }
    }

    public ReturnType process(Node head){

        if(head == null){
            return new ReturnType(0,0);
        }

        Node left = head.left;
        ReturnType leftRes = process(left);

        Node right = head.right;
        ReturnType rightRes = process(right);

        int max_instance = Math.max(Math.max(leftRes.max_instance,rightRes.max_instance),leftRes.h + rightRes.h + 1);

        return new ReturnType(max_instance,Math.max(leftRes.h,rightRes.h)+1);
    }
}

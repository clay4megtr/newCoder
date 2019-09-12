package org.clay.test3;

/**
 * 二叉树的最远距离
 */
public class TreeMaxLength {


    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class Struct{
        private int max_length; //子树的最远距离
        private int h;  //子树的高度

        public Struct(int max_length,int h){
            this.max_length = max_length;
            this.h = h;
        }
    }

    public static Struct getMaxLength(Node node){

        if(node == null){
            return new Struct(0,0);
        }

        Struct left_struct = getMaxLength(node.left);
        Struct right_struct = getMaxLength(node.right);

        int max_length = Math.max(Math.max(left_struct.max_length,right_struct.max_length),left_struct.h + right_struct.h + 1);

        return new Struct(max_length,Math.max(left_struct.h,right_struct.h)+1);
    }

    public static void main(String[] args) {

    }
}

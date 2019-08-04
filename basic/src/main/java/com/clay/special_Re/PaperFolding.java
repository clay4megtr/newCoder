package com.clay.special_Re;

import java.util.Stack;

public class PaperFolding {

    public static void printAllFolds(int N) {
        process(true, N, 0);
    }

    /**
     * @param down  是否向下
     * @param n     共折几次
     * @param level 当前是第几折
     */
    public static void process(boolean down,int n,int level){
        if(level == n){
            return;
        }

        process(true,n,level+1);
        System.out.println(down ? "down" : "up");
        process(false,n,level+1);
    }

    public static class Node{
        private Node left;
        private Node right;
        private boolean down;

        public Node(boolean down){
            this.down = down;
        }
    }

    public static void constract(Node node,int level,int N){

        if(level == N){
            return;
        }

        node.left = new Node(true);
        node.right = new Node(false);

        constract(node.left,level+1,N);
        constract(node.right,level+1,N);
    }

    public static void midOrderPrint(Node node){
        if(node == null){
            return;
        }
        midOrderPrint(node.left);
        System.out.println(node.down ? "down" : "up");
        midOrderPrint(node.right);
    }

    public static void main(String[] args) {
        int N = 4;
        printAllFolds(N);

        System.out.println("========");

        Node node = new Node(true);
        constract(node,1,N);
        midOrderPrint(node);
    }
}

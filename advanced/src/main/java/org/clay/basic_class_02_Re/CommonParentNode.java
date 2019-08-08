package org.clay.basic_class_02_Re;

/**
 * 二叉树的最近公共祖先
 */
public class CommonParentNode {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    /**
     * 假设是二叉搜索树
     * @return
     */
    public static Node process(Node head,Node left,Node right){

        if(head == null){
            return head;
        }

        if(left.value > right.value){
            return process(head,right,left);
        }

        if(head.value >= left.value && head.value <= right.value){
            return head;
        }else if(head.value > right.value){
            return process(head.left,left,right);
        }else{
            return process(head.right,left,right);
        }
    }


    /**
     * 普通二叉树
     * @return
     */
    public static Node process1(Node head,Node left,Node right){


        return null;
    }


    public static void main(String[] args) {

        Node head = new Node(6);
        head.left = new Node(2);
        head.right = new Node(8);

        head.left.left = new Node(0);
        head.left.right = new Node(4);

        head.right.left = new Node(7);
        head.right.right = new Node(9);

        head.left.right.left = new Node(3);
        head.left.right.right = new Node(5);

        System.out.println(process(head,new Node(3),new Node(4)).value);
    }
}

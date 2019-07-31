package org.clay.test1;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.LinkedList;
import java.util.Queue;

public class IsCBT {

    public static class Node{
        private int val;
        private Node left;
        private Node right;

        public Node(int val){
            this.val = val;
        }
    }

    public static boolean isCBT(Node head){

        Queue<Node> queue = new LinkedList<>();

        queue.offer(head);
        boolean flag = false;

        while(!queue.isEmpty()){

            Node node = queue.poll();

            if((node.left != null || node.right != null) && flag){
                return false;
            }

            if(node.right != null && node.left == null){
                return false;
            }
            //这种写法和最后面的代码是等效的；
            /*if((node.right == null && node.left != null) || (node.right == null && node.left == null)){
                System.out.println(node.val);
                flag = true;  //open stage
            }*/

            if(node.left != null){
                queue.offer(node.left);
            }

            if(node.right != null){
                queue.offer(node.right);
            }else{
                flag = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.left.left.left = new Node(6);

        System.out.println(isCBT(head));
    }
}
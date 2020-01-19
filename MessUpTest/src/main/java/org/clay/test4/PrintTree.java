package org.clay.test4;

import java.util.LinkedList;
import java.util.Queue;

public class PrintTree {

    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    /**
     * 分层打印，并换行
     */
    public static void levelPrint(Node head){

        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        Node last = head;
        Node nLast = null;

        while(!queue.isEmpty()){

            Node cur = queue.poll();
            System.out.print(cur.value + "  ");

            if(cur.left != null){
                queue.offer(cur.left);
                nLast = cur.left;
            }

            if(cur.right != null){
                queue.offer(cur.right);
                nLast = cur.right;
            }

            if(cur == last){
                System.out.println();
                last = nLast;
            }
        }
    }

    /**
     * 蛇形打印
     * 从左到右：从尾部加，从头部出，先压左再压右
     * 从右到左：从头部加，从尾部出，先压右再压左
     */
    public static void zigPrint(Node head){

        LinkedList<Node> queue = new LinkedList<>();
        boolean lr = true;
        queue.offerLast(head);
        Node last = head;
        Node nLast = null;

        while(!queue.isEmpty()){

            Node cur;
            if(lr){
                cur = queue.pollFirst();
                if(cur.left != null){
                    queue.offerLast(cur.left);
                    nLast = nLast == null ? cur.left : nLast;
                }

                if(cur.right != null){
                    queue.offerLast(cur.right);
                    nLast = nLast == null ? cur.right : nLast;
                }
            }else{
                cur = queue.pollLast();
                if(cur.right != null){
                    queue.offerFirst(cur.right);
                    nLast = nLast == null ? cur.right : nLast;
                }
                if(cur.left != null){
                    queue.offerFirst(cur.left);
                    nLast = nLast == null ? cur.left : nLast;
                }
            }

            System.out.print(cur.value + "  ");

            if(cur == last){
                System.out.println();
                last = nLast;
                nLast = null;
                lr = !lr;
            }


        }
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        levelPrint(head);

        System.out.println("======================");
        zigPrint(head);
    }
}

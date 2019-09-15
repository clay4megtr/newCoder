package org.clay.Book_Re_Other;

public class BST2LinkedList {


    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    private static Node head;
    private static Node tail;

    public static Node convert(Node root){
        process(root);
        return head;
    }

    public static void process(Node head){

        if(head == null){
            return;
        }
        process(head.left);
        createList(head);
        process(head.right);
    }

    private static void createList(Node cur) {
        cur.left = tail;
        if(tail == null){
            head = cur;
        }else{
            tail.right = cur;
        }
        tail = cur;
    }

    public static void main(String[] args) {

        Node head = new Node(10);
        head.left = new Node(6);
        head.right = new Node(12);
        head.left.left = new Node(4);
        head.left.right = new Node(8);
        head.right.left = new Node(11);
        head.right.right = new Node(13);

        Node lisHead = convert(head);
        while(lisHead != null){
            System.out.println(lisHead.value);
            lisHead = lisHead.right;
        }
    }
}
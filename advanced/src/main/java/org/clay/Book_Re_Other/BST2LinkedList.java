package org.clay.Book_Re_Other;

/**
 * 搜索二叉树转换为双向链表
 */
public class BST2LinkedList {


    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    //这种方式相当于创建了两个新的节点，然后以中序遍历的方式往这两个节点上追加；
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

    //==============================================================

    //要求：不能创建任何新的节点：
    public static Node convert1(Node root){

        Node head = root;
        while(head.left != null){
            head = head.left;
        }
        process1(root);

        return head;
    }

    public static void process1(Node root){

        if(root == null){
            return;
        }

        Node pre = root.left, next = root.right;

        while(pre != null && pre.right != null){
            pre = pre.right;
        }

        while(next != null && next.left != null){
            next = next.left;
        }

        process(root.left);
        process(root.right);

        root.left = pre;
        if(pre != null){
            pre.right = root;
        }

        root.right = next;
        if(next != null){
            next.left = root;
        }
    }


    public static void main(String[] args) {

        Node head = new Node(10);
        head.left = new Node(6);
        head.right = new Node(12);
        head.left.left = new Node(4);
        head.left.right = new Node(8);
        head.right.left = new Node(11);
        head.right.right = new Node(13);

        /*Node lisHead = convert(head);
        while(lisHead != null){
            System.out.println(lisHead.value);
            lisHead = lisHead.right;
        }*/

        System.out.println("====================");

        Node lisHead1 = convert1(head);
        while(lisHead1 != null){
            System.out.println(lisHead1.value);
            lisHead1 = lisHead1.right;
        }
    }
}
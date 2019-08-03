package org.clay.classFour_Re_1;

import java.util.Stack;

public class PreInPosTraversal {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 先序遍历
     */
    public static void preOrderRecur(Node head) {
        if(head == null){
            return;
        }
        System.out.println(head.value);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    /**
     * 中序遍历
     */
    public static void inOrderRecur(Node head) {
        if(head == null){
            return;
        }
        inOrderUnRecur(head.left);
        System.out.println(head.value);
        inOrderUnRecur(head.right);
    }

    /**
     * 后序遍历
     */
    public static void posOrderRecur(Node head) {
        if(head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.value);
    }

    /**
     * 非递归实现先序遍历
     * 为什么用栈？
     * 压入的时候从上到下，那么弹出的时候就是从下往上。
     * 先压右，再压左，那么弹出的时候会先弹左，再弹右。
     */
    public static void preOrderUnRecur(Node head) {

        Stack<Node> stack = new Stack<>();
        stack.push(head);

        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.value);

            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }


    /**
     * 非递归实现中序遍历
     * 一压，就压左边一留，
     * 所以压一留左边界，再依次往外弹，弹到某一个节点再去遍历它右孩子的过程
     * 实际上就模拟了左，中，右的过程。
     * 整棵树是可以被左边界分解的。
     */
    public static void inOrderUnRecur(Node head) {

        if(head != null){
            Stack<Node> stack = new Stack<>();

            while(!stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.println(head.value);
                    head = head.right;
                }
            }
        }
    }

    /**
     * 非递归实现后序遍历
     * 两个栈实现
     * 第一个栈：中右左，打印的时候存到一个栈中去。
     * 第二个栈：弹出的时候就是左右中。
     */
    public static void posOrderUnRecur1(Node head) {

        System.out.println("posOrderUnRecur1");

        Stack<Node> stack = new Stack<>();
        Stack<Node> newStack = new Stack<>();
        stack.push(head);

        while(!stack.isEmpty()){
            Node cur = stack.pop();
            newStack.push(cur);
            if(cur.left != null){
                stack.push(cur.left);
            }
            if(cur.right != null){
                stack.push(cur.right);
            }
        }
        while(!newStack.isEmpty()){
            System.out.println(newStack.pop().value);
        }
    }

    /**
     * 只用一个栈实现后序遍历
     * geek
     */
    public static void posOrderUnRecur2(Node h) {
        /*System.out.print("pos-order: ");
        if (h != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(h);
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && h != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().value + " ");
                    h = c;
                }
            }
        }
        System.out.println();*/
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        posOrderUnRecur1(head);
        posOrderUnRecur2(head);
    }
}
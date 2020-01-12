package org.clay.classFour_Re_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsBSTAndCBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isBST(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;

        int last = Integer.MIN_VALUE;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                if(cur.value < last){
                    return false;
                }
                last = cur.value;
                cur = cur.right;
            }
        }

        return true;
    }

    /**
     * 是否是完全二叉树 (按层遍历)
     * 1.如果一个节点只有右子树，没有左子树，肯定不是完全二叉树
     * 2.如果一个节点不是左右孩子双全(有左没右，或者左右都没有)，那么之后的节点肯定都是叶子节点
     */
    public static boolean isCBT(Node head) {

        boolean isStageTwo = false;

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        while(!queue.isEmpty()){
            Node cur = queue.poll();

            if(isStageTwo && (cur.left != null || cur.right != null)){
                return false;
            }

            if(cur.left == null && cur.right != null){
                return false;
            }

            if((cur.left != null && cur.right == null) || (cur.left == null && cur.right == null)){
                isStageTwo = true;
            }

            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }

        return true;
    }

    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.right = new Node(5);

        printTree(head);
        System.out.println(isCBT(head));
    }
}
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

    /**
     * 是否是完全二叉树
     */
    public static boolean isCBT(Node head) {
        if(head == null){
            return true;
        }
        boolean leaf = false;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);

        while(!queue.isEmpty()){
            Node cur = queue.poll();

            if(leaf){
                if(cur.left != null || cur.right != null){  //第二阶段开启之后，后面的节点只能是叶子节点，
                    return false;
                }
            }

            if(cur.right != null && cur.left == null){   //有右没左，直接返回false
                return false;
            }

            /*if((cur.left != null && cur.right == null) || (cur.left == null && cur.right == null)){  //有左没右，或者左右都没有
                leaf = true;
            }*/

            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){    //
                queue.offer(cur.right);
            }else{
                leaf = true;
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
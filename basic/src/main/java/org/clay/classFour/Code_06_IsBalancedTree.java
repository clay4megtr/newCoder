package org.clay.classFour;

/**
 * 平衡二叉树：平衡性是用来解决效率问题的。
 * 高度套路化
 * 1.左树是否平
 * 2.右树是否平
 * 3.左子树高度
 * 4.右子树高度
 *
 * 递归极好用：分析可能性：就开始设计递归函数，需要收集什么样的信息都定义好。
 * 然后按照子过程也交给我这样的信息，我自己也加工出这样的信息， 往上级结构返回，
 * 可解决的问题非常多。
 */
public class Code_06_IsBalancedTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class ReturnData {
        public boolean isB;
        public int h;

        public ReturnData(boolean isB, int h) {
            this.isB = isB;
            this.h = h;
        }
    }

    //===========第一种方法============================
    public static boolean isB(Node head) {
        return process(head).isB;
    }

    private static ReturnData process(Node head) {
        if (head == null) {
            return new ReturnData(true, 0);
        }
        ReturnData leftRes = process(head.left);
        if (!leftRes.isB) {
            return new ReturnData(false, 0);
        }
        ReturnData rightRes = process(head.right);
        if (!rightRes.isB) {
            return new ReturnData(false, 0);
        }
        if(Math.abs(leftRes.h - rightRes.h) > 1){
            return new ReturnData(false,0);
        }
        return new ReturnData(true,Math.max(leftRes.h, rightRes.h) + 1);
    }


    //===============第二种方法=================================
    public static boolean isBalance(Node head) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head, 1, res);
        return res[0];
    }

    public static int getHeight(Node head, int level, boolean[] res) {
        if (head == null) {
            return level;
        }
        int lH = getHeight(head.left, level + 1, res);
        if (!res[0]) {
            return level;
        }
        int rH = getHeight(head.right, level + 1, res);
        if (!res[0]) {
            return level;
        }
        if (Math.abs(lH - rH) > 1) {
            res[0] = false;
        }
        return Math.max(lH, rH);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isBalance(head));
    }
}

package org.clay.advanced_class_03;

public class Code_01_MorrisTraversal {

    /**
     * 使用递归的方式实现二叉树的先序、中序、后序遍历
     * 将打印置于不同位置可以实现不同的遍历效果
     */
    public static void process(Node head) {
        if (head == null) {
            return;
        }
        // 1
        //System.out.println(head.value);
        process(head.left);
        // 2
        //System.out.println(head.value);
        process(head.right);
        // 3
        //System.out.println(head.value);
    }

    public static class Node {
        public int value;
        Node left;
        Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * Morris遍历实现二叉树的中序遍历
     * 去掉打印，就是标准的实现；
     */
    public static void morrisIn(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) { //找到左子树最右节点
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {//说明是第一次到达当前节点
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            //如果有左子树，要把左子树处理完了，再去打印，因为中序打印的顺序是左中右，
            System.out.print(cur.value + " ");//将打印语句放在第二次到达有左子树的当前节点
            cur = cur.right;
        }
        System.out.println();
    }

    /**
     * Morris遍历的先序遍历
     */
    public static void morrisPre(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left; //左子树第一个节点
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) { //当cur的左子树的最右节点是null的时候，就是第一次来到这个节点的时候；
                    mostRight.right = cur;
                    System.out.print(cur.value + " "); //所以，此时直接打印；
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {// 如果一个节点没有左子树，说明只到这个节点一次，所以直接打印；
                System.out.print(cur.value + " ");
            }
            cur = cur.right;
        }
        System.out.println();
    }

    /**
     * Morris遍历的后序遍历
     */
    public static void morrisPos(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {  //大if
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    //首先它在大的if里，说明这个节点可以回到自己两次，
                    //其实是在第二次来到这个节点的时机，把打印时机放在了这里；
                    printEdge(cur.left); //逆序打印左子树的右边界
                }
            }
            cur = cur.right;
        }
        printEdge(head);//函数返回之前，单独打印整棵树的右边界；
        System.out.println();
    }

    public static void printEdge(Node head) {
        Node tail = reverseEdge(head);
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    public static Node reverseEdge(Node from) {
        Node pre = null;
        Node next = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
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
        head.right.left = new Node(5);
        head.right.right = new Node(7);
        printTree(head);
        morrisIn(head);
        morrisPre(head);
        morrisPos(head);
        printTree(head);
    }
}

package org.clay.classFour;


/**
 * 求一颗完全二叉树的子节点个数
 * 时间复杂度：每一层遍历的节点个数只会有一个，一共有O（logN）层。
 * 到了这个节点，还会遍历这个节点右子树的最左边的边界，又是O（logN），
 * 所以时间复杂度是O（logN）的平方
 */
public class Code_08_CompleteTreeNodeNumber {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     *  主函数
     *  一定是完全二叉树
     */
    public static int nodeNum(Node head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    /**
     * @param node  当前节点
     * @param level 当前节点在第几层，
     * @param h      整棵树的深度（层数）
     * @return      以node为头的整棵树的节点个数
     */
    public static int bs(Node node, int level, int h) {
        if (level == h) {  //level是最后一层，说明node是叶子节点，所以以node为头的整棵树节点个数是一个。
            return 1;
        }
        if (mostLeftLevel(node.right, level + 1) == h) {//node的右子树的最左的深度到没到整体最深的深度。
            return (1 << (h - level)) + bs(node.right, level + 1, h);//说明node的左子树是一颗完全二叉树，深度是level-1.
        } else {
            return (1 << (h - level - 1)) + bs(node.left, level + 1, h);
        }
    }

    /**
     * @param node
     * @param level
     * @return  整棵树最左的边界到了哪一层。
     */
    public static int mostLeftLevel(Node node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));

    }
}

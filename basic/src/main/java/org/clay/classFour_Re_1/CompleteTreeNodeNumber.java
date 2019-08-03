package org.clay.classFour_Re_1;

/**
 * 求一颗完全二叉树的子节点个数
 * 时间复杂度：每一层遍历的节点个数只会有一个，一共有O（logN）层。
 * 到了这个节点，还会遍历这个节点右子树的最左边的边界，又是O（logN），
 * 所以时间复杂度是O（logN）的平方
 */
public class CompleteTreeNodeNumber {

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
        return getNum(head,1,mostLeftLevel(head, 1));
    }

    public static int getNum(Node head,int level,int h){
        if(level == h){
            return 1;
        }
        if(mostLeftLevel(head,level) == mostLeftLevel(head.right,level +1)){
            return Double.valueOf(Math.pow(2,h-level)).intValue() + getNum(head.right,level+1,h);
        }else{
            return Double.valueOf(Math.pow(2,h-level-1)).intValue() + getNum(head.left,level+1,h);
        }
    }



    /**
     * @param node
     * @param level 之前所在的层
     * @return 整棵树最左的边界到了哪一层。
     */
    public static int mostLeftLevel(Node node, int level) {
        while(node != null){
            level += 1;
            node = node.left;
        }
        return level -1;
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
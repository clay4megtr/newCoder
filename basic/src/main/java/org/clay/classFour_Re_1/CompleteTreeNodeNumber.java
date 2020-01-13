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

    public static int nodeNum(Node head){

        return getRes(head,1,mostLeftLevel(head,1));
    }

    public static int getRes(Node head, int level, int h){

        if(level == h){
            return 1;
        }

        if(mostLeftLevel(head.right,level+1) == h){
            return (int) (Math.pow(2,h-level) + getRes(head.right,level+1,h));
        }else{
            return (int) (Math.pow(2,h-level-1) + getRes(head.left,level+1,h));
        }
    }

    public static int mostLeftLevel(Node head,int level){

        while(head != null){
            level++;
            head = head.left;
        }
        return level-1;
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
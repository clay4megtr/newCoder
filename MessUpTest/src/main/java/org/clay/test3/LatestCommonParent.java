package org.clay.test3;

public class LatestCommonParent {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getInBST(Node head,Node left, Node right){

        if(head == null){
            return head;
        }

        if(left.value > right.value){
            return getInBST(head,right,left);
        }

        if(head.value <= right.value && head.value >= left.value){
            return head;
        }else if(head.value > right.value){
            return getInBST(head.left,left,right);
        }else{
            return getInBST(head.right,left,right);
        }
    }

    /**
     * 普通二叉树
     * 递归遍历找到所给定的两个结点，然后向上标记，直到有一个结点的左子结点和右子结点都不为空返回即可。
     * @return
     */
    public static Node get(Node head,Node left, Node right){

        if(head == null || head == left || head == right){
            return head;
        }

        Node left_res = get(head.left,left,right);
        Node right_res = get(head.right,left,right);

        if(left_res != null && right_res != null){
            return head;
        }

        return left_res != null ? left_res : right_res;
    }
}

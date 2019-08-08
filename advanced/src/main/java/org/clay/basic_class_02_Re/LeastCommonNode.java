package org.clay.basic_class_02_Re;

/**
 * 找一棵树的两个节点的最低公共祖先
 */
public class LeastCommonNode {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 假设是BST
     * @return
     */
    public static Node process(Node head,Node left,Node right){

        if(head == null){
            return head;
        }

        if(left.value > right.value){
            return process(head,right,left);
        }

        if(head.value <= right.value && head.value >= left.value){
            return head;
        }else if(head.value > right.value){
            return process(head.left,left,right);
        }else{
            return process(head.right,left,right);
        }
    }

    /**
     * 普通二叉树
     * 这里的技巧是如果left和right是父子关系，虽然子节点不会被触发，但是最终的结果还是会返回父节点的，以为只有父节点一直往上返回的值才不为null
     */
    public static Node process1(Node head,Node left,Node right){

        //System.out.println("left: " + left.value);
        //System.out.println("right: " + right.value);

        if(head == null || head == left || head == right){
            return head;
        }

        Node left_res = process1(head.left,left,right);
        Node right_res = process1(head.right,left,right);

        if(left_res != null && right_res != null){
            return head;
        }

        Node res = left_res != null ? left_res : right_res;

        return res;
    }

    public static void main(String[] args) {

        Node node = new Node(3);
        node.left = new Node(4);
        node.right = new Node(2);

        node.left.left = new Node(11);
        node.left.right = new Node(6);
        node.right.left = new Node(9);
        node.right.right = new Node(7);

        node.left.right.left = new Node(1);
        node.left.right.right = new Node(10);

        System.out.println(process1(node,node.left.right.left,node.left.right).value);
    }
}

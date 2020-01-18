package org.clay.Book_Re_Other;

public class SubTree {

    static class Node {
        int val = 0;
        Node left = null;
        Node right = null;

        public Node(int val) {
            this.val = val;
        }
    }

    //t1为head的树是否包含t2为head的树
    public static boolean contains(Node t1,Node t2){
        return check(t1,t2) || contains(t1.left,t2) || contains(t1.right,t2);
    }

    public static boolean check(Node t1,Node t2){
        if(t2 == null){
            return true;
        }

        if(t1 == null || t1.val != t2.val){
            return false;
        }

        return check(t1.left,t2.left) && check(t1.right,t2.right);
    }


    public static void main(String[] args) {

        SubTree s = new SubTree();

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);
        root1.right.left.left = new Node(9);
        root1.right.right.right = new Node(10);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.right.left = new Node(9);
        root2.right.right = new Node(10);

        //System.out.println(s.isSubTree(root1,root2));

    }
}

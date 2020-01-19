package org.clay.test4;

public class ContainsSubTree {

    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public static boolean contains(Node head1,Node head2){
        return check(head1,head2) || contains(head1.left,head2) || contains(head1.right,head2);
    }

    public static boolean check(Node head1,Node head2){
        if(head2 == null){
            return true;
        }
        //head2 != null
        if(head1 == null || head1.value != head2.value){
            return false;
        }
        return check(head1.left,head2.left) && check(head1.right,head2.right);
    }
}

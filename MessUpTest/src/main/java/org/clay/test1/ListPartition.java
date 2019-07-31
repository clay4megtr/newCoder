package org.clay.test1;

public class ListPartition {

    public static class Node{
        private int val;
        private Node next;

        public Node(int val){
            this.val = val;
        }
    }

    public static Node partition(Node head,int num){

        Node lH = null;
        Node lT = null;

        Node eH = null;
        Node eT = null;

        Node bH = null;
        Node bT = null;

        Node next = null;

        while(head != null){

            next = head.next;
            head.next = null;

            if(head.val < num){
                if(lH == null){
                    lH = head;
                    lT = head;
                }else{
                    lT.next = head;
                    lT = head;
                }
            }else if(head.val == num){
                if(eH == null){
                    eH = head;
                    eT = head;
                }else{
                    eT.next = head;
                    eT = head;
                }
            }else{
                if(bH == null){
                    bH = head;
                    bT = head;
                }else{
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }

        if(lT != null){
            lT.next = eH;
        }

        if(eT != null){
            eT.next = bH;
        }

        return lH;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
//        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = partition(head1, 5);
        printLinkedList(head1);
    }
}

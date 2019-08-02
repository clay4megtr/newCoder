package org.clay.classThree_Re_1;

public class SmallerEqualBigger {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }


    public static Node listPartition2(Node head, int num){

        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;

        Node root = head;

        while(root != null){

            Node next = root.next;
            root.next = null;

            if(root.value < num){
                if(sH == null){
                    sH = root;
                    sT = root;
                }else{
                    sT.next = root;
                }
            }else if(root.value == num){
                if(eH == null){
                    eH = root;
                    eT = root;
                }else{
                    eT.next = root;
                }
            }else{
                if(bH == null){
                    bH = root;
                    bT = root;
                }else{
                    bT.next = root;
                }
            }
            root = next;
        }

        if(sT != null){
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if(eT != null){
            eT.next = bT;
        }

        return sH != null ? sH : eH != null ? eH : bH;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
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
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);

    }
}

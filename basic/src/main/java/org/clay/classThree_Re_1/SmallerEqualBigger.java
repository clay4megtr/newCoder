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

        Node cur = head;

        while(cur != null){
            if(cur.value < num){
                if(sH == null){
                    sH = cur;
                    sT = cur;
                }else{
                    sT.next = cur;
                    sT = cur;
                }
            }else if(cur.value == num){
                if(eH == null){
                    eH = cur;
                    eT = cur;
                }else{
                    eT.next = cur;
                    eT = cur;
                }
            }else{
                if(bH == null){
                    bH = cur;
                    bT = cur;
                }else{
                    bT.next = cur;
                    bT = cur;
                }
            }
            cur = cur.next;
        }

        if(sT != null){
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eT != null) {
            eT.next = bH;
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

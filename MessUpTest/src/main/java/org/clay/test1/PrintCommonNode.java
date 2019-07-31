package org.clay.test1;

import org.omg.CORBA.NO_IMPLEMENT;

public class PrintCommonNode {

    public static class Node{
        public int val;
        public Node next;
        public Node(int data){
            this.val = data;
        }
    }

    public static Node reverse(Node head){

        Node next = head.next;

        head.next = null;  //pay attention
        while(next != null){
            Node sec = next.next;
            next.next = head;
            head = next;
            next = sec;
        }
        return head;
    }


    public static void printComm(Node head1, Node head2){

        while(head1 != null && head2 != null){

            if(head1.val < head2.val){
                head1 = head1.next;
            }else if(head1.val > head2.val){
                head2 = head2.next;
            }else{
                System.out.println(head1.val);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
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
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node head = reverse(node1);

        printLinkedList(head);
    }
}

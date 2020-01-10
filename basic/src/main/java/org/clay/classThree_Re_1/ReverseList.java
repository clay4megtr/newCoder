package org.clay.classThree_Re_1;

/**
 * 旋转单链表
 */
public class ReverseList {

    static class Node{

        public Integer value;
        public Node next;

        public Node(Integer value){
            this.value = value;
        }
    }

    public static Node reverse(Node head){

        Node pre = null;
        Node cur = head;
        Node next = null;

        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void printList(Node head){

        while(head != null){
            System.out.println(head.value);
            head = head.next;
        }
    }


    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);

        printList(head1);

        Node head2 = reverse(head1);

        printList(head2);
    }
}

package org.clay.Book_Re_LinkedList;

/**
 * 单链表中删除指定值的节点
 */
public class DeleteValueNode {

    static class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public static void delete(Node head,int value){

        Node last = head;
        Node cur = head.next;

        while(cur != null && cur.value != value){
            last = last.next;
            cur = cur.next;
        }

        Node next = cur.next;
        cur.next = null;
        last.next = next;
    }

    public static void printNode(Node head){
        while(head != null){
            System.out.println(head.value);
            head = head.next;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        printNode(head);

        delete(head,2);

        printNode(head);
    }
}

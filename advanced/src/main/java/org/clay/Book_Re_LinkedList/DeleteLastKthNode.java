package org.clay.Book_Re_LinkedList;

/**
 * 删除倒数第k个节点
 */
public class DeleteLastKthNode {

    static class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    //移除倒数第index个；
    public static void delete(Node head, int index){

        Node cur = head;
        Node last = head;

        while(index > 0){
            cur = cur.next;
            index--;
        }

        while(cur.next != null){
            cur = cur.next;
            last = last.next;
        }

        Node next = last.next.next;
        last.next.next = null;
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

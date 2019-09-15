package org.clay.test3;

public class ReverseNode {

    public static class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    /**
     * 反转单向链表
     */
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

    public static class DoubleNode{
        int value;
        DoubleNode last;
        DoubleNode next;

        public DoubleNode(int value){
            this.value = value;
        }
    }

    /**
     * 反转双向链表
     */
    public static DoubleNode reverse2(DoubleNode head){

        DoubleNode pre = null;
        DoubleNode cur = head;

        while(cur != null){
            DoubleNode next = cur.next;
            cur.next = pre;
            cur.last = next;

            pre = cur;
            cur = next;
        }
        return pre;
    }


    public static void main(String[] args) {

        /*Node head = new Node(1);
        head.next = new Node(2);
        head.next.next= new Node(3);
        head.next.next.next = new Node(4);

        Node newHead = reverse(head);

        while(newHead != null){
            System.out.println(newHead.value);
            newHead = newHead.next;
        }*/

        DoubleNode head = new DoubleNode(1);

        head.last = null;
        head.next = new DoubleNode(2);

        head.next.last = head.next;
        head.next.next = new DoubleNode(3);

        head.next.next.last = head.next.next;
        head.next.next.next = new DoubleNode(4);

        head.next.next.next.last = head.next.next.next;
        head.next.next.next.next = null;

        DoubleNode newHead = reverse2(head);

        while(newHead != null){
            System.out.println(newHead.value);
            newHead = newHead.next;
        }
    }
}

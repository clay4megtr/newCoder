package org.clay.test1;

public class HuiWenList {

    public static class Node{
        private int val;
        private Node next;

        public Node(int val){
            this.val = val;
        }
    }

    public static boolean isPalindrome3(Node head){

        if (head == null || head.next == null) {
            return true;
        }

        Node k = head;
        Node m = head;

        while(k.next != null && k.next.next != null){
            m = m.next;
            k = k.next.next;
        }

        Node next = m.next;

        m.next = null;
        while(next != null){
            Node sec = next.next;
            next.next = m;
            m = next;
            next = sec;
        }

        Node reHead = m;
        Node tail = m;
        Node hhead = head;

        boolean flag = true;

        while(tail != null && hhead != null){
            if(hhead.val != tail.val){
                flag = false;
                break;
            }
            tail = tail.next;
            hhead = hhead.next;
        }

        //before  return true, fix list
        Node rNext = reHead.next;

        reHead.next = null;

        while(rNext != null){
            Node reSec = rNext.next;
            rNext.next = reHead;
            reHead = rNext;
            rNext = reSec;
        }


        return flag;
    }

    public static void main(String[] args) {

        Node head = null;
        printLinkedList(head);
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}

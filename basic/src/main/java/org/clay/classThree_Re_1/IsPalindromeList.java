package org.clay.classThree_Re_1;

import org.clay.classThree.Code_11_IsPalindromeList;

import java.util.Stack;

public class IsPalindromeList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isPali1(Node root){
        boolean res = true;

        Stack<Node> stack = new Stack<>();

        Node cur = root;

        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        cur = root;
        while(cur != null){
            if(cur.value != stack.pop().value){
                res = false;
            }
            cur = cur.next;
        }

        return res;
    }

    /**
     * 空间复杂度 O(N/2)
     * @param head
     * @return
     */
    public static boolean isPalindrome2(Node head){

        if(head == null || head.next== null){
            return true;
        }

        Node fast = head;
        Node slow = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Stack<Node> stack = new Stack<>();

        while(slow != null){
            stack.push(slow);
            slow = slow.next;
        }


        while (!stack.isEmpty()){
            if(stack.pop().value != head.value){
                return false;
            }
            head = head.next;
        }

        return true;
    }


    public static Node reverse(Node head){

        Node pre = null;

        while(head != null){
            Node next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static boolean isPalindrome3(Node head){

        boolean res = true;

        Node fast = head;
        Node slow = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node pre = null;
        Node next = null;
        while(slow != null){
            next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        Node head1 = head;
        Node head2 = pre;

        while(head1 != null){
            if(head1.value != head2.value){
                res = false;
                break;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        //pre -> head   slow -> pre
        while (pre != null){
            next = pre.next;
            pre.next = slow;
            slow = pre;
            pre = next;
        }

        return res;
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

        Node head = null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        printLinkedList(head);
        head = reverse(head);
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }
}

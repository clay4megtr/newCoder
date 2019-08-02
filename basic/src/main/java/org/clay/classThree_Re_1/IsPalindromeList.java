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
        boolean res = false;

        Stack<Integer> stack = new Stack<>();
        Node head = root;
        while(head != null){
            stack.push(head.value);
            head = head.next;
        }

        while(root != null){
            if(root.value != stack.pop()){
                res = false;
            }
            root = root.next;
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

        Node fast = head;           //快指针从头结点出发
        Node slow = head;      //慢指针从第二个节点出发

        while(fast.next != null && fast.next.next != null){  //这里有一个规律，记住就就可以了，快指针停止的时候，慢指针一定在中间
            slow = slow.next;
            fast = fast.next.next;
        }

        Stack<Integer> stack = new Stack<>();

        while(slow != null){
            stack.push(slow.value);
            slow = slow.next;
        }

        while(!stack.isEmpty()){
            if(stack.pop() != head.value){
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

        fast = slow.next;
        slow.next = null;
        //此时slow 就是 pre，fast就是head
        while(fast != null){
            Node next = fast.next;
            fast.next = slow;
            slow = fast;
            fast = next;
        }

        //此时slow指向尾节点
        Node reverHead = slow;
        Node head1 = head;

        while(head1 != null && slow != null){
            if(head1.value != slow.value){
                res = false;
            }
            head1 = head1.next;
            slow = slow.next;
        }

        //恢复节点
        Node pre = null;
        while(reverHead != null){
            Node next = reverHead.next;
            reverHead.next = pre;
            pre = reverHead;
            reverHead = next;
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
        System.out.print(isPalindrome2(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }
}

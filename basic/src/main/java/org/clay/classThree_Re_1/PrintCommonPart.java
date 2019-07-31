package org.clay.classThree_Re_1;

import org.clay.classThree.Code_10_PrintCommonPart;

public class PrintCommonPart {

    public static class Node {
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }

    public static void printNum(Node root1, Node root2){

        while(root1 != null && root2 != null){

            if(root1.value == root2.value){
                System.out.println(root1.value);
                root1 = root1.next;
                root2 = root2.next;
            }else if(root1.value < root2.value){
                root1 = root1.next;
            }else{
                root2 = root2.next;
            }
        }
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
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        printLinkedList(node1);
        printLinkedList(node2);
        printNum(node1, node2);

    }
}

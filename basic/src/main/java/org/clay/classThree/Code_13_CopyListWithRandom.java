package org.clay.classThree;

import java.util.HashMap;

/**
 * 深度拷贝链表（链表有两个指针，一个next，一个random）
 */
public class Code_13_CopyListWithRandom {

    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     *  方法一：使用hashmap，
     *  两个链表压根就没有发生过联系，就只是通过map联系起来的。
     */
    public static Node copyListWithRand1(Node head) {
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        while (cur != null) {   //生成每个节点的拷贝节点，
            map.put(cur, new Node(cur.value));//new Node 就是生成的拷贝节点。
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {  //为每个拷贝节点的next节点和random节点赋值
            map.get(cur).next = map.get(cur.next);// 1' 的next指针应该指向1的next指针的内个节点的拷贝节点，
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);//返回原始头链表的拷贝节点：也就是1' 节点
    }

    /**
     * 方法二：先重新排列链表，1->1'->2->2'->3->3'->null
     * 1'就是1的拷贝节点，2'就是2的拷贝节点。。。
     * 本质就是让一个节点的拷贝节点放在这个节点的下一个节点，省掉map。
     *
     * 1'的random指针指向1的random的拷贝节点，2'的random指针指向2的random的拷贝节点，.。。。
     * 而一个节点的拷贝节点就是它的下一个节点，
     * random 指针是不会互相干扰的，
     * 再互相分离。
     */
    public static Node copyListWithRand2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;
        // copy node and link to every node
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next  =next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        // set copy node rand
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        Node res = head.next;
        cur = head;
        // split
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }

    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

    }

}

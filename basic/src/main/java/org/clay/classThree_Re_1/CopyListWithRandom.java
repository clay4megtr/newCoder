package org.clay.classThree_Re_1;

import java.util.HashMap;

public class CopyListWithRandom {

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

        HashMap<Node,Node> map = new HashMap<Node, Node>();

        Node cur = head;
        while(cur != null){
            map.put(cur,new Node(cur.value));
            cur = cur.next;
        }

        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }

        return map.get(head);
    }
}

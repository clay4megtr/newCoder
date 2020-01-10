package org.clay.classThree_Re_1;

import java.util.HashMap;
import java.util.Map;

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

        Map<Node,Node> map = new HashMap<>();

        Node cur = head;
        while (cur != null){
            map.put(cur,new Node(cur.value));
            cur = cur.next;
        }

        Node cur1 = head;
        while(cur1 != null){
            Node t = map.get(cur1);
            t.next = map.get(cur1.next);
            t.rand = map.get(cur1.rand);
            cur1 = cur1.next;
        }

        return map.get(head);
    }
}

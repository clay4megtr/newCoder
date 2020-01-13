package org.clay.classThree_Re_1;

/**
 * 首先记住一点：一个链表有环，一个链表无环，这种情况不可能存在相交节点
 */
public class FindFirstIntersectNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 主函数
     * @param head1 第一个链表
     * @param head2 第二个链表
     * @return  两个链表的第一个相交节点，
     */
    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        //如果一个有环，一个无环，肯定不会有相交节点。
        return null;
    }

    /**
     * 返回第一个入环的节点
     * 如果链表无环：返回null
     * 如果链表要构成一个环，最少需要三个节点
     * @return
     */
    public static Node getLoopNode(Node head) {

        Node fast = head;
        Node slow = head;

        while(fast != slow){
            if(fast.next == null || fast.next.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        //此时说明肯定有环，
        fast = head;
        while(fast.next != slow.next){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    /**
     * 两个无环链表的相交问题
     * @param head1 链表1
     * @param head2 链表2
     * @return  返回第一个相交节点
     * 肯定是个Y结构
     */
    public static Node noLoop(Node head1, Node head2) {

        int diff = 0;
        Node cur1 = head1;
        Node cur2 = head2;

        while(cur1 != null){
            diff++;
            cur1 = cur1.next;
        }

        while(cur2 != null){
            diff--;
            cur2 = cur2.next;
        }
        if(cur1 != cur2){
            return null;
        }

        cur1 = diff >= 0 ? head1 : head2;
        cur2 = cur1 == head2 ? head1 : head2;

        diff = Math.abs(diff);
        while(diff > 0){
            cur1 = cur1.next;
            diff--;
        }

        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;
    }

    /**
     *  两个有环链表的相交问题。
     * @param head1 链表1的头节点
     * @param loop1 链表1的入环节点
     * @param head2 链表2的头节点
     * @param loop2 链表2的入环节点
     * @return  第一个相交节点
     * 看图片
     */
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {

        if(loop1 == loop2){  //
            Node cur1 = head1;
            Node cur2 = head2;
            int diff = 0;

            while(cur1 != loop1){
                cur1 = cur1.next;
                diff++;
            }

            while(cur2 != loop1){
                cur2 = cur2.next;
                diff--;
            }

            cur1 = diff >= 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;

            diff = Math.abs(diff);

            while(diff > 0){
                cur1 = cur1.next;
                diff--;
            }

            while(cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }

            return cur1;
        }else{
            boolean noMeet = true;

            Node next = loop1.next;

            while(next != loop1){
                if(next == loop2){
                    noMeet = false;
                    break;
                }
                next = next.next;
            }

            if(noMeet){
                return null;
            }else{
                return loop1;
            }
        }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);
    }
}

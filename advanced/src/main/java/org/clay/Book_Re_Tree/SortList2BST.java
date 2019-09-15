package org.clay.Book_Re_Tree;

public class SortList2BST {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static TreeNode sortedListToBST(ListNode head) {

        if(head == null){
            return null;
        }
        if(head.next == null){
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode last = head;

        while(fast.next != null && fast.next.next != null){
            last = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        last.next = null;

        TreeNode node = new TreeNode(slow.val);

        if(head != slow){
            node.left = sortedListToBST(head);
        }
        node.right = sortedListToBST(fast);

        return node;
    }

    public static void main(String[] args) {

        //[-10,-3,0,5,9]
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        TreeNode newHead = sortedListToBST(head);
        System.out.println();
    }
}

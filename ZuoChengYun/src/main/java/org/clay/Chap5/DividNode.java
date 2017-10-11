package org.clay.Chap5;

/**
 * 链表的分化，
 * 给定一个节点，一个阈值
 * 把阈值左边的放在链表的左边，
 * 把阈值右边的放在链表的右边，
 * @author clay
 */
public class DividNode {

	static class ListNode{
		int val;
		ListNode next = null;
		ListNode(int val){
			this.val = val;
		}
	}
	
	/**
	 * 构造两个节点即可。一个是全部比阈值小的链表，一个是全部比阈值大的链表，
	 * 最后两个链表相连。
	 */
	public ListNode divid(ListNode head, int num){
		ListNode smallHead = null;
		ListNode smallTail = null;
		
		ListNode bigHead = null;
		ListNode bigTail = null;
		
		ListNode next;
		
		while(head != null){
			next = head.next;
			head.next = null;
			
			if(head.val <= num){//放在前边
				if(smallHead == null){
					smallHead = head;
					smallTail = head;
				}else{
					smallTail.next = head;
					smallTail = head;
				}
			}else{
				if(bigHead == null){
					bigHead = head;
					bigTail = head;
				}else{
					bigTail.next = head;
					bigTail = head;
				}
			}
			head = next;
		}
		
		if(smallTail != null && smallHead != null){
			smallTail.next = bigHead;
		}
		
		return smallTail == null ? bigHead : smallHead;
	}
	
	public static void main(String[] args) {
		DividNode dn = new DividNode();
		
		ListNode root1 = new ListNode(1);
		ListNode root2 = new ListNode(5);
		ListNode root3 = new ListNode(3);
		ListNode root4 = new ListNode(4);
		ListNode root5 = new ListNode(2);
		
		root1.next = root2;
		root2.next = root3;
		root3.next = root4;
		root4.next = root5;
		
		ListNode deleteNode = dn.divid(root1, 3);
		
		while(deleteNode != null){
			System.out.println(deleteNode.val);
			deleteNode = deleteNode.next;
		}
	}
}

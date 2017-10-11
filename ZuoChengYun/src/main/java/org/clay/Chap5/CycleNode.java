package org.clay.Chap5;

public class CycleNode {

	class Node {
		int val;
		Node next = null;
		Node(int val) {
			this.val = val;
		}
	}
	/**
	 * 是否有环
	 */
	public boolean hasCycle(Node head){
		Node low = head;
		Node fast = head.next;
		Node place = null;
		
		while(low != fast){
			
			if(low.next == null){
				return false;
			}
			low = low.next;
			
			if(fast.next == null || fast.next.next == null){
				return false;
			}
			fast = fast.next.next;
		}
		//如果有环，让head指针从投开始走，low继续走，
		while(head != low){
			head = head.next;
			low = low.next;
		}
		//相等了，说明此时这个节点就是刚刚开始有环的节点
		place = head;
		
		return true;
	}
}

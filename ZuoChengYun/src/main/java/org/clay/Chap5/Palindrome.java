package org.clay.Chap5;

import java.util.Stack;

public class Palindrome {

	class ListNode{
		int val;
		ListNode next = null;
		ListNode(int val){
			this.val = val;
		}
	}
	
	/**
	 * 判断是否为回文结构
	 * 时间复杂度为O(n)
	 */
	public boolean isPalindrome(ListNode head){
		boolean tmp = true;
		ListNode p = head;
		
		Stack<Integer> stack = new Stack<>();
		while(p != null){
			stack.push(p.val);
			p = p.next;
		}
		
		while(!stack.isEmpty()){
			if(head.val != stack.pop()){
				tmp = false;
			}
			head = head.next;
		}
		return tmp;
	}
	
	/**
	 * 判断是否为回文结构
	 * 快慢指针
	 * 时间复杂度为O(n/2)
	 */
	public boolean isPalindrome2(ListNode head){
		
		if(head == null || head.next == null){
			return false;
		}
		ListNode slow = head;
		ListNode quick = head;
		
		Stack<Integer> stack = new Stack<>();
		while(quick != null && quick.next.next != null){
			stack.push(slow.val);
			slow = slow.next;
			quick = quick.next.next;
		}
		
		/**
		 * 5 7 3 2 3 7 5		   奇数，quick是最后一个。  这个也是回文结构，此时不把2压入栈中。
		 * 4 3 2 1 1 2 3 4	
		 */
		if(quick != null && quick.next == null){  //此时是奇数
			slow = slow.next;	//意思就是当是5 7 3 2 3 7 5时，只比较5 7 3 和  3 7 5
		}
		
		while (!stack.isEmpty() && slow != null) {
			int val = stack.pop();
			if (val != slow.val){
				return false;
			}
			slow = slow.next;
		}
		
		return true;
	}
}

package org.clay.Chap5;

public class InsertNode {

	class ListNode{
		int val;
		ListNode next = null;
		ListNode(int val){
			this.val = val;
		}
	}
	/**
	 * 元素的值A
	 * 对应的nxt指向的元素编号
	 * 构造出这个环形链表，并插入该值
	 * [1,3,4,5,7],[1,2,3,4,0],2
	 * 返回：{1,2,3,4,5,7}
	 */
	public ListNode insertNode(int[] A, int[] nxt, int val){
		
		ListNode node = new ListNode(val);
		if(A == null || A.length <= 0){
			node.next = node;
			return node;
		}
		
		ListNode head = new ListNode(A[0]);
		ListNode tmp = head;
		for(int i = 0; i < nxt.length-1; i++){
			ListNode newNode = new ListNode(A[nxt[i]]);
			tmp.next = newNode;
			tmp = newNode;
		}
		tmp.next=head;//环形链表
		
		ListNode pre = head;
		ListNode cur = head.next;
	
		while(cur != head){
			if(val >= pre.val && val <= cur.val){
				break;
			}
			pre = cur;
			cur = cur.next;
		}
		//说明要插在head的前面
		if(cur == head){
			tmp.next = node;
			node.next = head;
			
			if(val <= head.val){//再判断一下到底要返回哪个值
				return node;
			}else{
				return head;
			}
		}else{
			//插到pre和cur之间
			node.next = cur;
			pre.next = node;
			return head;
		}
	}
	public static void main(String[] args) {
		
		InsertNode in = new InsertNode();
		
		int[] array = new int[]{1,3,4,5,7};
		int[] nxt = new int[]{1,2,3,4,0};
		
		ListNode insertNode = in.insertNode(array, nxt, 0);
		System.out.println(insertNode.val);
	}
}

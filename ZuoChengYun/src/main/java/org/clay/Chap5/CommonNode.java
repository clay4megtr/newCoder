package org.clay.Chap5;

/**
 * 打印两个链表的公共节点
 * @author clay
 */
public class CommonNode {

	class ListNode{
		int val;
		ListNode next = null;
		ListNode(int val){
			this.val = val;
		}
	}
	
	public void commonNodes(ListNode head1, ListNode head2){
		
		if(head1 == null || head2== null){
			return;
		}
		
		while(head1 != null && head2 != null){
			
			if(head1.val < head2.val){
				head1 = head1.next;
			}else if(head2.val < head2.val){
				head2 = head2.next;
			}else{
				head1 = head1.next;
				head2 = head2.next;
				System.out.println(head1.val);
			}
		}
	}
}

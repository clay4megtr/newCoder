package org.clay.Chap5;
/**
 * 只给定一个节点，但是不给头节点
 * 如何删除node，
 * 要求时间复杂度为O(1)
 * @author clay
 */
public class DeleteNode {

	class ListNode{
		int val;
		ListNode next = null;
		ListNode(int val){
			this.val = val;
		}
	}
	
	public void deleteNode(ListNode node){
		
		//把下一个节点的节点值赋给此节点，删除下一个节点即可
		//但是是有问题的，例如要删除的节点已经是最后一个节点。
		ListNode next = node.next;//下一个节点
		node.val = next.val;
		node.next = node.next.next;
	}
}

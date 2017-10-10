package org.clay.Chap5;

/**
 * 给定一个链表的头结点，再给定一个值，
 * 然后把链表中val是这个值的节点全部删除
 * @author clay
 */
public class DeleteNodeByValue {

	static class ListNode{
		int val;
		ListNode next = null;
		ListNode(int val){
			this.val = val;
		}
	}

	/**
	 * 记住需要用两个指针即可
	 */
	public ListNode deleteNode(ListNode root, int num){
		
		ListNode pre = root;
		ListNode cur = root;
		while(cur != null){
			if(cur.val == num){
				pre.next = cur.next;
			}else{
				pre = cur;
			}
			cur = cur.next;
		}
		return root;
	}
	
	public static void main(String[] args) {
		
		DeleteNodeByValue dn = new DeleteNodeByValue();
		
		ListNode root1 = new ListNode(1);
		ListNode root2 = new ListNode(2);
		ListNode root3 = new ListNode(3);
		ListNode root4 = new ListNode(4);
		ListNode root5 = new ListNode(5);
		
		root1.next = root2;
		root2.next = root3;
		root3.next = root4;
		root4.next = root5;
		
		ListNode deleteNode = dn.deleteNode(root1, 2);
		
		while(deleteNode != null){
			System.out.println(deleteNode.val);
			deleteNode = deleteNode.next;
		}
	}
}

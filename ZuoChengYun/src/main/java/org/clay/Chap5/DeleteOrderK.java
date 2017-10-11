package org.clay.Chap5;

/**
 * 删除倒数第K个节点
 * @author clay
 */
public class DeleteOrderK {

	class Node {
		int val;
		Node next = null;

		Node(int val) {
			this.val = val;
		}
	}

	public void delete(Node root, int k){
		
		Node first = root;
		Node last = root;
		
		while(first != null){
			
			if(k > 0){
				k--;
				first = first.next;
			}else{
				first = first.next;
				last = last.next;
			}
		}
		//此时要删除的节点就是last之后的节点
		last.next = last.next.next;
	}
}

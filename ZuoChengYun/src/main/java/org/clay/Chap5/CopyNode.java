package org.clay.Chap5;

/**
 * 复杂链表的复制
 * 两个指针，一个next指针，一个random指针
 * @author clay
 */
public class CopyNode {

	static class RandomListNode {
		int label;
		RandomListNode next = null;
		RandomListNode random = null;

		RandomListNode(int label) {
			this.label = label;
		}
	}
	
	/**
	 * 克隆复杂链表
	 */
	public RandomListNode Clone(RandomListNode head){
		
		cloneList(head); //每个节点后面都新增一个相同的节点
		
		constructSibling(head);//给每个新增的节点添加上random指针
		
		return split(head);  //切分之后返回所有新增的节点
	}

	private RandomListNode split(RandomListNode head) {
		
		RandomListNode newHead = null;
		RandomListNode newTail = null;
		RandomListNode cur = head;
		RandomListNode next = head.next;
		while(cur != null){
			
			if(newHead == null){
				newHead = next;
				newTail = next;
			}else{
				newTail.next = cur.next;
				newTail = cur.next;
			}
			
			cur.next = newTail.next;
			cur = newTail.next;
		}
		return newHead;
	}

	private void constructSibling(RandomListNode head) {
		
		RandomListNode cur = head;
		RandomListNode next = head.next;
		
		while(next != null){
			next.random = cur.random;
			
			cur = next;
			next = next.next;
		}
	}

	private void cloneList(RandomListNode head) {
		
		RandomListNode next = null;
		
		while(head != null){
			next = head.next;
			
			RandomListNode newNode = new RandomListNode(head.label);
			newNode.next = head.next;
			head.next = newNode;
			
			head = next;
		}
	}
	
	public static void main(String[] args) {
		
		CopyNode cn = new CopyNode();
		
		RandomListNode root1 = new RandomListNode(1);
		RandomListNode root2 = new RandomListNode(2);
		RandomListNode root3 = new RandomListNode(3);
		
		root1.next = root2;
		root2.next = root3;
		
		root1.random = root3;
		root2.random = root1;
		root3.random = root1;
		
		RandomListNode clone = cn.Clone(root1);
		
		while(clone != null){
			System.out.println(clone.label);
			clone = clone.next;
		}
	}
}

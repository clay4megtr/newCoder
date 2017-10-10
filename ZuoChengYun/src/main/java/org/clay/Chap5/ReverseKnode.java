package org.clay.Chap5;

public class ReverseKnode {
	class ListNode{
		int val;
		ListNode next = null;
		ListNode(int val){
			this.val = val;
		}
	}
	//复习：链表反转
	public ListNode inverse(ListNode head){
		
		ListNode pre = null;
		ListNode cur = head;
		ListNode next = null;
		
		while(cur != null){
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
	public ListNode kInverse(ListNode head, int k){
		
		if(head == null || k < 2 || head.next.next == null){
			return head;
		}
		ListNode cur = head;	//正在遍历的当前节点
		ListNode start = null;
		
		//pre节点很重要，它永远保持着要逆转的子链表的第一个节点的上一个节点，以 3,2,1,6,5,4 为例，开始的时候为null，
		//第一次逆转时，start是head 3，逆转完之后 start 赋给pre，pre就变为了3，且逆转完之后链表是1,2,3,4,5,6， 所以pre又变成了下一次需要逆转的链表的前一个节点。
		//也作为判断是否是第一次逆转的标准，如果为null，就代表是第一次遍历，此时head要变值，此例中如果是刚开始遍历，head要变为1，否则head维持原值。
		ListNode pre = null;
		ListNode next = null;	//待遍历的下一个节点

		int count = 1;
		while(cur!= null){
			next = cur.next;
			if(count == k){		//该反转了。
			
				//如果是刚开始遍历的话，start要从head开始，
				//如果不是第一次遍历的话，start就要从pre节点的下一个节点开始。
				//因为pre永远维护的是需要反转的子链表的前一个节点。
				start = pre == null ? head : pre.next;
				
				//注意这里：pre==null，说明是第一次刚开始遍历，此时就把head置为cur，因为下面resign反转之后，cur才是最终的head
				//后续遍历，head就不能再改变了，只能指向投节点。
				head = pre == null ? cur : head;
				resign(pre,start,cur,next);
				
				pre = start;
				count=0;
			}
			count++;
			cur = next;
		}
		return head;
	}
	/**
	 * 左， 开始，结束，右
	 */
	public void resign(ListNode left,ListNode start, ListNode end, ListNode right){
		
		ListNode pre = start;
		ListNode cur = start.next;
		ListNode next = null;
		//反转
		while(cur != right){
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		//如果left不为空，因为反转之后end才是最左边的，所以left.next设置为end
		if(left != null){
			left.next = end;
		}
		//反转之后，start是最右边的，所以start的next设置为right。
		start.next = right;
	}
}

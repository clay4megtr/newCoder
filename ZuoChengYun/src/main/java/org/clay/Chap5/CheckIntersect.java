package org.clay.Chap5;

/**
 * 判断两个链表是否相交 
 * 相交的话返回第一个相交的节点
 * 不相交的话返回空 
 * 要求时间复杂度O(N+M) 额外时间复杂度O(1)
 * @author clay
 */
public class CheckIntersect {

	class Node {
		int val;
		Node next = null;

		Node(int val) {
			this.val = val;
		}
	}

	/*
	 * 判断是否相交，如果相交，得到第一个相交点 只有都是有环，或者都是无环的情况，才有可能相交
	 */
	public static Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		if (loop1 == null && loop2 == null) {
			return noLoop(head1, head2);
		}
		if (loop1 != null && loop2 != null) {
			return bothLoop(head1, loop1, head2, loop2);
		}
		return null;
	}

	/*
	 * 判断是否存在环，如果存在，则找出环的入口点。
	 * 入口点找法：快慢指针，块指针走两步，满指针走一步，如果存在循环，则在慢指针走完环前，总会和快指针相遇。
	 * 从头指针和相遇点同时向后走，相遇的点必定是入口点。
	 */
	private static Node getLoopNode(Node head) {

		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node n1 = head.next; // n1 -> slow
		Node n2 = head.next.next; // n2 -> fast
		while (n1 != n2) {
			if (n2.next == null || n2.next.next == null) {
				return null;
			}
			n2 = n2.next.next;
			n1 = n1.next;
		}
		n2 = head; // n2 -> walk again from head
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;
	}

	/* 无环时的判断方法 */
	private static Node noLoop(Node head1, Node head2) {

		if (head1 == null || head2 == null) {
			return null;
		}
		Node cur1 = head1;
		Node cur2 = head2;
		int n = 0;
		while (cur1.next != null) {
			n++;
			cur1 = cur1.next;
		}
		while (cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		if (cur1 != cur2) {// 如果 链表1 和链表2 到最后都不相等的话，说明肯定没有相交的节点
			return null;
		}
		// 否则，说明一定有相交的节点
		cur1 = n > 0 ? head1 : head2; // n > 0， 说明head长，
		cur2 = cur1 == head1 ? head2 : head1; // cur2就是短的内个。

		n = Math.abs(n);
		while (n != 0) { // 把cur1指向 两个链表还剩相等长度的地方
			n--;
			cur1 = cur1.next;
		}
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}

		return cur1;// 肯定会出现相同的节点，因为上面已经判断了最后一个节点。
	}

	/* 有环时的判断方法 */
	private static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {

		Node cur1 = null;
		Node cur2 = null;
		//如果两个链表在刚入环的时候，就已经相交了，那么就要寻找这个相交节点之前的相交节点，
		//此时和寻找无环链表的相交节点的方法相同，只是寻找无环链表的相交节点的终止条件是null，
		//而寻找这个相交节点之前的相交节点的终止条件是以       刚入环时的节点        为终止条件。
		if (loop1 == loop2) {
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			while (cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while (cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			while (n != 0) {
				n--;
				cur1 = cur1.next;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
			
		//如果两个链表在刚入环的时候，还没有相交，那么只有两种情况，第一种情况是两个链表根本没有相交节点，此时返回null即可，
		//第二种情况是一颗土豆插两个电线的形状，此时返回node1和node2两个中的任何一个均可。具体可看图：有环链表的相交节点情况
		} else {
			cur1 = loop1.next;
			while (cur1 != loop1) {
				//环形遍历，查看是否能碰到loop2.碰到了就说明是第二种情况，没碰到说明是第一种情况。
				if (cur1 == loop2) {
					return loop1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}
}

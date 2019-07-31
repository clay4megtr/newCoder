package org.clay.classFour;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 判断是否是搜索二叉树：任何一个节点：左子树都比它小，右子树都比它大。
 *
 * 完全二叉树
 */
public class Code_07_IsBSTAndCBT {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

    /**
     * 自己用非递归中序遍历的方式实现
     * 如何判断是否是搜索二叉树：中序遍历是从小到大排序的。
     * 中序遍历是升序的。
     */
    public static boolean isBSTinTraver(Node head){

        Stack<Node> stack = new Stack<Node>();

        int lastNum = Integer.MIN_VALUE;
        while(!stack.isEmpty() || head != null){
            if(head != null){
                stack.push(head);
                head = head.left;
            }else{
                head = stack.pop();
                if(head.value < lastNum){
                    return false;
                }else{
                    lastNum = head.value;
                }
                head = head.right;
            }
        }

        return true;
    }


    /**
     * 所谓的more死什么遍历
     * 这个先不用看
     */
	public static boolean isBST(Node head) {
		if (head == null) {
			return true;
		}
		boolean res = true;
		Node pre = null;
		Node cur1 = head;
		Node cur2 = null;
		while (cur1 != null) {
			cur2 = cur1.left;
			if (cur2 != null) {
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;
				}
				if (cur2.right == null) {
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				} else {
					cur2.right = null;
				}
			}
			if (pre != null && pre.value > cur1.value) {
				res = false;
			}
			pre = cur1;
			cur1 = cur1.right;
		}
		return res;
	}

	public static boolean isCBT(Node head) {
		if (head == null) {
			return true;
		}
		Queue<Node> queue = new LinkedList<Node>();
		boolean leaf = false;//阶段状态：表示是否开启了这个阶段：
		Node l = null;
		Node r = null;
		queue.offer(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			l = head.left;
			r = head.right;
			if ((leaf && (l != null || r != null))//如果开启了阶段：那么之后的节点都应该是叶子节点。
                    ||
                    (l == null && r != null)) {//第一种情况，
				return false;
			}
			if (l != null) {
				queue.offer(l);
			}
			if (r != null) {
				queue.offer(r);
			} else { //右为空，可能有左，也可能没左。
				leaf = true;       //可以这么写的原因是左孩子为null，右孩子不为null在情况一已经抛弃掉了。
			}
		}
		return true;
	}

    // for test -- print tree
	public static void printTree(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public static void printInOrder(Node head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.value + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		Node head = new Node(4);
		head.left = new Node(2);
		head.right = new Node(6);
		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.right.left = new Node(5);

		printTree(head);
		System.out.println(isBST(head));
		System.out.println(isCBT(head));

	}
}
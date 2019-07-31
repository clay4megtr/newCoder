package org.clay.classFour;

/**
 * 寻找一颗二叉树节点的后继节点（中序遍历的下一个节点）
 * 1.如果这个节点有右子树，那么后继节点一定是这个右子树上最左的节点。
 * 2.如果这个节点没有右子树，那么就考察这个节点到底作为哪一个节点左子树的最后一个节点。
 * X没有右子树，通过X的父指针找到X的父节点，如果X是父节点的右孩子，继续往上走，直到某个X节点是它父节点的左孩子停止。
 * X没有右子树，通过X的父指针找到X的父节点，如果X是父节点的右孩子，继续往上走，直到某个X节点是它父节点的左孩子停止。
 * 此时的父节点就是原始X节点的后继。
 */
public class Code_03_SuccessorNode {

	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node parent;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node getSuccessorNode(Node node) {
		if (node == null) {
			return node;
		}
		if (node.right != null) {//有右子树，就找右子树上最左边的节点。
			return getLeftMost(node.right);
		} else {                 //没有右子树，就一直向上找。
			Node parent = node.parent;
			while (parent != null && parent.left != node) {//x节点不是父节点的左孩子，就一直向上找，直到X节点是父节点的左孩子，返回父节点（就是后继节点）
				node = parent;
				parent = node.parent;
			}
			return parent;
		}

	}

    /**
     * 右子树上最左边的节点。
     */
	public static Node getLeftMost(Node node) {
		if (node == null) {
			return node;
		}
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	public static void main(String[] args) {
		Node head = new Node(6);
		head.parent = null;
		head.left = new Node(3);
		head.left.parent = head;
		head.left.left = new Node(1);
		head.left.left.parent = head.left;
		head.left.left.right = new Node(2);
		head.left.left.right.parent = head.left.left;
		head.left.right = new Node(4);
		head.left.right.parent = head.left;
		head.left.right.right = new Node(5);
		head.left.right.right.parent = head.left.right;
		head.right = new Node(9);
		head.right.parent = head;
		head.right.left = new Node(8);
		head.right.left.parent = head.right;
		head.right.left.left = new Node(7);
		head.right.left.left.parent = head.right.left;
		head.right.right = new Node(10);
		head.right.right.parent = head.right;

		Node test = head.left.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left.left.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left.right.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.left.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.right; // 10's next is null
		System.out.println(test.value + " next: " + getSuccessorNode(test));
	}

}

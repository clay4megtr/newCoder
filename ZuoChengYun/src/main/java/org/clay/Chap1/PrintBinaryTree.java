package org.clay.Chap1;

import java.util.LinkedList;


class TreeNode {
	String val;
	TreeNode left;
	TreeNode right;

	public TreeNode(String val) {
		this.val = val;
	}
}

public class PrintBinaryTree {

	/**
	 * 层序遍历：按照层来打印 
	 * 思路：
	 * last指针：表示正在打印的当前行的最右节点
	 * nLast指针：永远指向下一行的最右节点，原因是，每次遍历到一个节点，就把nLast指向它的右节点
	 * 当now指向last的时候，就说明nlast已经指向下面一层最右边的节点了，该把last = nlast的时候了。
	 */
	public void PrintBinaryTree(TreeNode root) {

		LinkedList<TreeNode> queue = new LinkedList<>();

		queue.push(root);

		TreeNode last = root;
		TreeNode nLast = null;
		TreeNode now = null;

		while (!queue.isEmpty()) {

			now = queue.removeFirst(); // now就代表每次要出栈的顺序。因为last指向的永远是当前行的最后一个节点，所以now指向last，就代表该换行了。
			System.out.print(now.val + " ,");
			if (now.left != null) {
				queue.add(now.left);
				nLast = now.left;
			}
			if (now.right != null) {
				queue.add(now.right);
				nLast = now.right;
			}

			if (now == last) { // 当now指向了了last，就代表这一行遍历完了，此时把
				System.out.println();
				last = nLast;
			}
		}
	}

	public static void main(String[] args) {

		PrintBinaryTree pbt = new PrintBinaryTree();

		TreeNode root = new TreeNode("1");
		TreeNode node1 = new TreeNode("2");
		TreeNode node2 = new TreeNode("3");
		TreeNode node3 = new TreeNode("4");
		TreeNode node4 = new TreeNode("5");

		root.left = node1;
		root.right = node2;

		node1.left = node3;
		node1.right = node4;

		pbt.PrintBinaryTree(root);

	}

}

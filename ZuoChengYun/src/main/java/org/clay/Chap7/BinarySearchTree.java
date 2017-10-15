package org.clay.Chap7;
import java.util.Stack;

/**
 * 判断是否是二叉搜索树
 * @author clay
 */
public class BinarySearchTree {
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	/**
	 * 中序遍历，查看是不是从小到大排列的即可
	 * @return
	 */
	public boolean isSearchTree(TreeNode head) {
		int tmp = Integer.MIN_VALUE;
		boolean res=  true;		//默认是
		
		TreeNode cur = head;
		Stack<TreeNode> stack = new Stack<>();
		while(!stack.isEmpty() || cur != null){
			while(cur != null){
				stack.push(cur);
				cur = cur.left;
			}
			TreeNode node = stack.pop();
			if(tmp == Integer.MIN_VALUE){
				tmp = node.val;
			}else{
				if(node.val > tmp){
					tmp = node.val;
				}else{
					res = false;
					break;		//如果发现后面的比前面的小了，直接返回false即可
				}
			}
			cur = node.right;
		}
		return res;
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(6);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(5);
		TreeNode node7 = new TreeNode(7);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		
		BinarySearchTree bst = new BinarySearchTree();
		System.out.println(bst.isSearchTree(node1));
	}
}

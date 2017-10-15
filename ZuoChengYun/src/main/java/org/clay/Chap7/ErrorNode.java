package org.clay.Chap7;

/**
 * 一棵树原本是搜索二叉树， 但是其中有两个节点调换了位置， 使得这棵二叉树不再是搜索二叉树， 找到这两个节点
 * 
 * @author clay
 */
public class ErrorNode {
	
	/*找出搜索二叉树中交换了位置的2个数：中序遍历找出减小的数，可能有1次减小或者2次较小, 
	即找出第一次减小时前面的数（大）和最后一次减小时后面的数（小）*/  
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	
}

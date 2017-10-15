package org.clay.Chap7;

import java.util.LinkedList;

/**
 * 判断是否是完全二叉树
 * @author clay
 */
public class CompleteBinaryTree {

	public static class TreeNode {

		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	/**
	 * 层序遍历，从左往右
	 * 如果当前节点有右孩子，没有左孩子，直接返回false
	 * 如果当前节点并不是左右孩子都有，那之后的节点必须都为叶节点，否则返回false
	 * 遍历过程中如果不返回false，那么返回true即可
	 */
	public boolean isColpleteBinaryTree(TreeNode head){
		
		TreeNode last = head;
		TreeNode nLast = null;
		TreeNode now = null;
		
		boolean leaf = true; // 叶子结点
		
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(head);
		
		while(!queue.isEmpty()){
			now = queue.removeFirst();
			
			if ((!leaf&&(now.left!=null||now.right!=null)) || (now.left == null && now.right != null)) {
		        // 如果之前层遍历的结点没有右孩子，且当前的结点有左或右孩子，直接返回false
		        // 如果当前结点有右孩子却没有左孩子，直接返回false
		        return false;
		      }
			
			if(now.left != null){		//注意操作的时候，操作的都是null
				queue.add(now.left);
				nLast = now.left;
			}
			if(now.right != null){
				queue.add(now.right);
				nLast = now.right;
			}else{
				//说明当前节点没有右子节点
				leaf = false;
			}
			
			if(now == last){
				last = nLast;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
//		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
//		node3.left = node6;
		node3.right = node7;
		
		CompleteBinaryTree cbt = new CompleteBinaryTree();
		System.out.println(cbt.isColpleteBinaryTree(node1));
	}
}

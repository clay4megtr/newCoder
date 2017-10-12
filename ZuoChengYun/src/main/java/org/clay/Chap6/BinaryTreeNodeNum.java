package org.clay.Chap6;


/**
 * 完全二叉树
 * 给定头结点head，
 * 返回节点个数
 * 如果节点数为N，则实现时间复杂度低于O(N)的解法
 * @author clay
 */
public class BinaryTreeNodeNum {

	class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	/**
	 * 时间复杂度为O(logH^2) H是高度
	 */
	public int getNodeNum(TreeNode root){
		if(root == null){
			return 0;
		}
		TreeNode tmpLeft = root.left;
		TreeNode tmpRight = root.right;
		if(tmpLeft == null){
			return 1;
		}
		if(tmpRight == null){
			return 2;
		}
		
		int leftHigt = 1;
		int rightHigt = 1;
		while(tmpLeft.left != null){
			tmpLeft = tmpLeft.left;
			leftHigt++;
		}
		while(tmpRight.right != null){
			tmpRight = tmpRight.right;
			rightHigt++;
		}
		
		if(leftHigt == rightHigt){
			//说明左子树是满二叉树
			//满二叉树的节点个数是(2^n)-1 这里要加上根节点。
			return (1 << leftHigt) + getNodeNum(root.right);
		}else{
			//说明右子树是满二叉树
			return (1 << rightHigt) + getNodeNum(root.left);
		}
	}
}


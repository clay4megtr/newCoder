package org.clay.Chap7;

public class MaxLength {
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public int nMaxLeft;// 左子树中的最长距离
		public int nMaxRight;// 右子树中的最长距离

		public TreeNode(int val) {
			this.val = val;
		}
	}

	private int nMaxLen = 0;

	/**
	 * 计算一个二叉树的最大距离有两个情况: 
	 * 情况A: 路径经过左子树的最深节点，通过根节点，再到右子树的最深节点。
	 * 情况B: 路径不穿过根节点，而是左子树或右子树的最大距离路径，取其大者。
	 */
	// 寻找树中最长的两段距离
	public void getMaxLength(TreeNode root) {
		// 遍历到叶子节点，返回
		if (root == null) {
			return;
		}
		// 如果左子树为空，那么该节点的左边最长距离为0
		if (root.left == null) {
			root.nMaxLeft = 0;
		}
		// 如果右子树为空，那么该节点的右边最长距离为0
		if (root.right == null) {
			root.nMaxRight = 0;
		}
		// 如果左子树不为空，递归寻找左子树最长距离
		if (root.left != null) {
			getMaxLength(root.left);
		}
		// 如果右子树不为空，递归寻找右子树最长距离
		if (root.right != null) {
			getMaxLength(root.right);
		}
		// 计算左子树最长节点距离
		if (root.left != null) {

			int nTempMax = 0;
			if (root.left.nMaxLeft > root.left.nMaxRight) {
				nTempMax = root.left.nMaxLeft;
			} else {
				nTempMax = root.left.nMaxRight;
			}
			root.nMaxLeft = nTempMax + 1;
		}
		// 计算右子树最长节点距离
		if (root.right != null) {

			int nTempMax = 0;
			if (root.right.nMaxLeft > root.right.nMaxRight) {
				nTempMax = root.right.nMaxLeft;
			} else {
				nTempMax = root.right.nMaxRight;
			}
			root.nMaxRight = nTempMax + 1;
		}
		// 更新最长距离
		if(root.nMaxLeft + root.nMaxRight > nMaxLen){
			nMaxLen = root.nMaxLeft + root.nMaxRight;
		}
	}
}

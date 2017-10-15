package org.clay.Chap7;

/**
 * 判断一棵树是否是AVL树
 * @author clay
 */
public class AVL {

	public static class TreeNode {

		public String val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(String val) {
			this.val = val;
		}
	}

	/**
	 * 递归遍历左子树
	 * 如果左子树中不满足AVL，则返回false
	 * 否则记录左子树高度
	 * 
	 * 递归遍历右子树
	 * 如果右子树中不满足AVL，则返回false
	 * 否则记录右子树高度
	 * 
	 * 如果左右高度差大于1，返回false
	 */
	public boolean isBalance(TreeNode head) {
		boolean[] res = new boolean[1];
		res[0] = true;
		
		getHeight(head, 1, res);
		
		return res[0];
	}
	
	/**
	 * 只求高度
	 */
	public int getHeight2(TreeNode head){
	
		if(head == null){
			return 0;
		}else{
			int i = getHeight2(head.left);
			int j = getHeight2(head.right);
			return (i > j) ? (i+1) : (j+1); 
		}
	}
	
	/**
	 * 求高度的同时
	 * 还要判断是否是AVL树
	 */
	public int getHeight(TreeNode head, int level, boolean[] res) {
		if(head == null){
			return level;
		}
		
		int lH = getHeight(head.left, level+1, res);
		if(!res[0]){	//如果一旦发现某棵子树不是AVL了，直接返回level
			return level;
		}
		
		int rH = getHeight(head.right, level+1, res);
		if(!res[0]){	//如果一旦发现某棵子树不是AVL了，直接返回level
			return level;
		}
		
		if(Math.abs(lH - rH) > 1){		//否则判断高度差是否大于1
			res[0] = false;
		}
		return Math.max(lH, rH);
	}
	
	public static void main(String[] args) {
		TreeNode head = new TreeNode("A");
		TreeNode node = new TreeNode("B");
		head.left = node;
		
		AVL av = new AVL();
		av.isBalance(head);
	}
}

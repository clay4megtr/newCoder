package org.clay.Chap7;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 求折痕 
 * 对折N次 
 * 从上到下打印所有折痕的方向
 * @author clay
 */
public class FlodPaper {
	public static class TreeNode {
		public String val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(String val) {
			this.val = val;
		}
	}
	/*
	 * 首先建立二叉树：显然这是一棵满二叉树，n就是这棵树的层数，按层遍历的方式建立起一棵二叉树，
	 * 使用一个队列，不需要考虑换行，先将root放入到queue中，然后弹出temp，并为其建立左右结点并分别放入queue中，
	 * 再弹出一个结点……根据规律，当弹出2^(n-1)-1个结点时恰好将全部结点建立并放入到队列中，于是返回的root结点就是新建二叉树的根结点。
	 */
	public TreeNode create(int n) {

		TreeNode root = new TreeNode("down");
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int count = 0;
		
		while(count < Math.pow(2, n-1)-1){
			TreeNode temp = queue.pop();
			count++;
			
			TreeNode left = new TreeNode("down");
			TreeNode right = new TreeNode("up");
			temp.left = left;
			temp.right = right;
			
			queue.add(left);
			queue.add(right);
		}
		
		return root;
	}
	/**
	 * 中序遍历，非递归
	 */
	public void print(TreeNode head) {

		TreeNode cur = head;
		Stack<TreeNode> stack = new Stack<>();
		
		while(!stack.isEmpty() || cur != null){
			
			while(cur != null){
				stack.push(cur);
				cur = cur.left;
			}
			TreeNode node = stack.pop();
			System.out.println(node.val);
			cur = node.right;
		}
	}
	public static void main(String[] args) {
		
		FlodPaper fp = new FlodPaper();
		TreeNode root = fp.create(4);
		fp.print(root);
	}
}

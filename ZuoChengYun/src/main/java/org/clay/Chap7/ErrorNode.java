package org.clay.Chap7;

import java.util.ArrayList;

/**
 * 一棵树原本是搜索二叉树， 但是其中有两个节点调换了位置，
 * 使得这棵二叉树不再是搜索二叉树， 
 * 找到这两个节点
 * @author clay
 */
public class ErrorNode {
	/*找出搜索二叉树中交换了位置的2个数：中序遍历找出减小的数，可能有1次减小或者2次较小, 
	即找出第一次减小时前面的数（大）和最后一次减小时后面的数（小）*/  
	
	/*
	 * 二叉搜索树按照中序遍历应该是一个升序数组，如果有错位节点，包括两种情况
	 * 情况1:1 5 3 4 2 ，其中共有两次降序数字对，分别为5 3与4 2，只要取第一对的较大数字与第二对的较小数字即可
	 * 情况2:1 2 4 3 5，其中只有一对降序数字，则直接返回即可。
	 * */
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public ArrayList<Integer> findError(TreeNode root){
		
		ArrayList<Integer> temp = new ArrayList<>();
		ArrayList<Integer> res = new ArrayList<>();
		
		midOrder(root, temp);
		
		Integer p1 = null;
		Integer p2 = null;
		
		for(int i = 0; i < temp.size(); i++){
			if(temp.get(i) > temp.get(i+1)){
				p1 = temp.get(i);
				p2 = temp.get(i+1);
				for(int j = i+1; j < temp.size(); j++){
					if(temp.get(j) > temp.get(j+1)){
						p2 = temp.get(j+1);
					}
				}
			}
			break;
		}
		res.add(p2);
		res.add(p1);
		return res;
	}
	/**
	 * 中序遍历   递归
	 */
	public void midOrder(TreeNode node, ArrayList<Integer> list){
		if(node == null){
			return;
		}else{
			midOrder(node.left, list);
			list.add(node.val);
			midOrder(node.right, list);
		}
	}
}

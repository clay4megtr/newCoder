package org.clay.Chap7;

import java.util.ArrayList;

/**
 * 树的序列化和反序列化
 * @author clay
 */
public class serialize {

	public static class TreeNode{
		
		public String val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode( String val){
			this.val = val;
		}
	}
	
	/**
	 * 序列化- 前序
	 */
	public void serialize(TreeNode root, StringBuilder builder){
		
		if(root == null){
			builder.append("#!");
		}else{
			builder.append(root.val + "!");
			serialize(root.left, builder);
			serialize(root.right, builder);
		}
	}
	
	/**
	 * 通过前序遍历的数据序列反向生成二叉树
	 * 	 * 				A
	 *  	B				C
	 * D		E					F
	 * 
	 * ABD##E##C#F##
	 * 
	 * 用ArrayList的原因是可以直接remove第一个元素，方便后续递归
	 */
	public TreeNode createBinaryTree(ArrayList<String> data){
	
		String d = data.get(0);
		TreeNode node;
		
		if(d.equals("#")){
			node = null;
			data.remove(0);
			return node;
		}
		
		node = new TreeNode(d);
		data.remove(0);
		node.left = createBinaryTree(data);
		node.right = createBinaryTree(data);
		
		return node;
	}
	
	public static void main(String[] args) {
		
		TreeNode nodeA = new TreeNode("A");
		TreeNode nodeB = new TreeNode("B");
		TreeNode nodeC = new TreeNode("C");
		TreeNode nodeD = new TreeNode("D");
		TreeNode nodeE = new TreeNode("E");
		
		nodeA.left = nodeB;
		nodeA.right = nodeC;
		
		nodeB.left = nodeD;
		nodeB.right = nodeE;
		
		
		serialize ss = new serialize();
		
		StringBuilder sb = new StringBuilder();
		
		ss.serialize(nodeA, sb);
		
		System.out.println(sb.toString());
	}
	
}

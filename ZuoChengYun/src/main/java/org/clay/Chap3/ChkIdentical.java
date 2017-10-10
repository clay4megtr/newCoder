package org.clay.Chap3;

import java.util.ArrayList;

class TreeNode {
	String val;
	TreeNode left;
	TreeNode right;

	public TreeNode(String val) {
		this.val = val;
	}
}

/**
 * 判断tree2中是否是tree1的子结构
 * @author clay
 */
public class ChkIdentical {

	public boolean chkIdentical(TreeNode tree1, TreeNode tree2){
		
		StringBuilder tree1Buider = new StringBuilder();
		StringBuilder tree2Buider = new StringBuilder();
		
		serialize(tree1,tree1Buider);
		serialize(tree2,tree2Buider);
		
		String tree1Res = tree1Buider.toString();
		String tree2Res = tree2Buider.toString();
		
		//现在问题转化为tree1Res中是否包含tree2Res
		for(int i = 0; i < tree1Res.length()-tree2Res.length()+1; i++){
			int j;
			for(j = 0; j < tree2Res.length(); j++){
				if(tree1Res.charAt(i+j) != tree2Res.charAt(j)){
					break;
				}
			}
			if(j == tree2Res.length()){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 序列化
	 */
	private void serialize(TreeNode tree, StringBuilder builder) {
		
		if(tree == null){
			builder.append("#!");
		}else{
			builder.append(tree.val + "!");
			serialize(tree.left,builder);
			serialize(tree.right,builder);
		}
	}
	
	/**
	 * 反序列化
	 */
	public TreeNode createBinaryTree(ArrayList<String> list){
		String d = list.get(0);
		TreeNode node;
		
		if(d.equals("#")){
			node = null;
			list.remove(0);
			return node;
		}
		node = new TreeNode(d);
		list.remove(0);
		node.left = createBinaryTree(list);
		node.right = createBinaryTree(list);
		
		return node;
	}
	
	public static void main(String[] args) {
		
	}
}

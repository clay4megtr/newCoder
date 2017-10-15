package org.clay.Chap7;

/**
 * 前驱节点：中序遍历序列的上一个节点
 * 后继节点：中序遍历序列的下一个节点
 * @author clay
 */
public class SpecialTree {

	public static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node parent;
		
		public Node(int val) {
			this.val = val;
		}
	}
	/**
	 * 特殊的二叉树（二叉搜索树），有一个父指针
	 * 给定一个节点，不一定是父节点
	 * 实现返回这个节点的后继节点的函数
	 */
	public Node findPostNode(Node node){
		
		//普通方法：一直通过parent指针找到最终的父节点，然后再中序遍历，找到这个节点的后继节点
		//最优解：时间复杂度O(L) L为此节点和其后继节点的距离，  空间复杂度为O(1)
		
		//具体过程看图
		//二叉查找树的删除也用到了此步骤，也可以查看二叉树笔记。
		Node postNode = null;
		if(node.right != null){
			postNode = node.right;
			
			while(postNode.left != null){
				postNode = postNode.left;
			}
			return postNode;
		}else{
			Node parent = node.parent;
			while(parent != null && node == parent.right){
				node = parent;
				parent = parent.parent;
			}
			return parent;
		}
	}
}

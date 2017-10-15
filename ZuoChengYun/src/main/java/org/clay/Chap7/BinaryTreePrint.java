package org.clay.Chap7;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树的打印
 * @author clay
 */
public class BinaryTreePrint {

	private TreeNode root = null;
	
	public BinaryTreePrint(){
		root = new TreeNode("A");
	}
	
	/**
	 * 构建一颗二叉树
	 * 				A
	 *  	B				C
	 * D		E					F
	 * 
	 */
	public void createBinaryTree(){
	
		TreeNode nodeB = new TreeNode("B");
		TreeNode nodeC = new TreeNode("C");
		TreeNode nodeD = new TreeNode("D");
		TreeNode nodeE = new TreeNode("E");
		TreeNode nodeF = new TreeNode("F");
		
		root.leftChild = nodeB;
		root.rightChild = nodeC;
		
		nodeB.leftChild = nodeD;
		nodeB.rightChild = nodeE;
		
		nodeC.rightChild = nodeF;
	}
	
	/**
	 * @return  树的高度
	 */
	public int getHight(){
		return getHight(root);
	}
	
	private int getHight(TreeNode node) {
		
		if(node == null){
			return 0;
		}else{
			int i = getHight(node.leftChild);
			int j = getHight(node.rightChild);
			return (i>j)? (i+1) : (j+1);
		}
	}
	
	/**
	 * 树的节点数目
	 * @author clay
	 */
	public int size(){
		return getSize(root);
	}

	private int getSize(TreeNode node) {
		
		if(node == null){
			return 0;
		}else{
			return 1+getSize(node.leftChild) + getSize(node.rightChild);
		}
	}
	
	/**
	 * 前序遍历
	 */
	public void preOrder(TreeNode node){
		if(node == null){
			return;
		}else{
			System.out.println(node.data);
			preOrder(node.leftChild);
			preOrder(node.rightChild);
		}
	}
	/**
	 * 栈实现先序遍历 	中左右
	 * 放进栈中的时候，
	 * 先放右孩子，再放左孩子
	 * 这样出栈的时候就会左孩子先出栈。
	 */
	public void nonRecPreOrder(TreeNode root){
		if(root == null){
			return;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			System.out.println(node.data);
			if(node.rightChild != null){
				stack.push(node.rightChild);
			}
			if(node.leftChild != null){
				stack.push(node.leftChild);
			}
		}
		
	}
	
	/**
	 * 中序遍历
	 */
	public void midOrder(TreeNode node){
		if(node == null){
			return;
		}else{
			preOrder(node.leftChild);
			System.out.println(node.data);
			preOrder(node.rightChild);
		}
	}
	
	/**
	 * 栈实现中序遍历
	 */
	public void nonRecMidOrder(TreeNode root){
		if(root == null){
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while(!stack.isEmpty() || cur != null){
			//依次把左节点全部压入栈中，
			while(cur != null){
				stack.push(cur);
				cur = cur.leftChild;
			}
			//只要cur == null, 就从stack中弹出并打印。
			TreeNode node = stack.pop();
			System.out.println(node.data);//然后把cur置为node的右节点
			cur = node.rightChild;
		}
	}
	
	/**
	 * 后序遍历
	 */
	public void postOrder(TreeNode node){
		if(node == null){
			return;
		}else{
			preOrder(node.leftChild);
			preOrder(node.rightChild);
			System.out.println(node.data);
		}
	}
	
	/**
	 * 栈实现后序遍历
	 * 放进栈中的时候，先放左，再放右边，区别于栈实现先序遍历的先放右再放左。
	 */
	public void nonRecPostOrder(TreeNode root){
		if(root == null){
			return;
		}
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		stack1.push(root);
		while(!stack1.isEmpty()){
			TreeNode cur = stack1.pop();
			stack2.push(cur);
			if(cur.leftChild != null){
				stack1.push(cur.leftChild);
			}
			if(cur.rightChild != null){
				stack1.push(cur.rightChild);
			}
		}
		while(!stack2.isEmpty()){
			System.out.println(stack2.pop());
		}
	}
	
	/**
	 * 层序遍历：按照层来打印 
	 * 思路：
	 * last指针：表示正在打印的当前行的最右节点
	 * nLast指针：永远指向下一行的最右节点，原因是，每次遍历到一个节点，就把nLast指向它的右节点
	 * 当now指向last的时候，就说明nlast已经指向下面一层最右边的节点了，该把last = nlast的时候了。
	 */
	public void levelOrder(TreeNode root) {

		LinkedList<TreeNode> queue = new LinkedList<>();

		queue.push(root);

		TreeNode last = root;
		TreeNode nLast = null;
		TreeNode now = null;

		while (!queue.isEmpty()) {

			now = queue.removeFirst(); // now就代表每次要出栈的顺序。因为last指向的永远是当前行的最后一个节点，所以now指向last，就代表该换行了。
			System.out.print(now.data + " ,"); // 否则，每次弹出都加到tmp中间结果中。
			if (now.leftChild != null) {
				queue.add(now.leftChild);
				nLast = now.leftChild;
			}
			if (now.rightChild != null) {
				queue.add(now.rightChild);
				nLast = now.rightChild;
			}

			if (now == last) { // 当now指向了了last，就代表这一行遍历完了，此时把
										// 这一行的数据存储到res中，然后把tmp清空。
				System.out.println();
				last = nLast;
			}
		}
	}
	
	public class TreeNode{
	
		public String data;
		public TreeNode leftChild;
		public TreeNode rightChild;
		
		public TreeNode( String data){
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		BinaryTreePrint tree = new BinaryTreePrint();
//		
//		tree.createBinaryTree();
//		
//		int height = tree.getHight();
//		
//		System.out.println("树的高度是:  " + height);
//		
//		int size = tree.size();
//		System.out.println("树的节点数目是 :" + size);
		
	}
}

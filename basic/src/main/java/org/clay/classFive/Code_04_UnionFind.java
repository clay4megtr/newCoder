package org.clay.classFive;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 并查集
 *
 */
public class Code_04_UnionFind {

	public static class Node {
		// whatever you like
	}

	public static class UnionFindSet {
		public HashMap<Node, Node> fatherMap;//key：某一个节点，value：节点的父节点
		public HashMap<Node, Integer> sizeMap;//某一个节点所在的集合有多少个节点。

		public UnionFindSet(List<Node> nodes) { // 只接受一次把全部的样本都给我，不接受一个一个的进来
			makeSets(nodes);
		}

		public void makeSets(List<Node> nodes) {
			fatherMap = new HashMap<Node, Node>();
			sizeMap = new HashMap<Node, Integer>();
			fatherMap.clear();
			sizeMap.clear();
			for (Node node : nodes) {
				fatherMap.put(node, node);  // 开始的时候都是一个元素就是一个集合，父指针指向自己
				sizeMap.put(node, 1); //每一个节点都是自己的代表节点
			}
		}

		//给定一个元素，向上找代表节点，过程中变扁平的行为
		private Node findHead(Node node) {
			Node father = fatherMap.get(node);
			if (father != node) {
				father = findHead(father);   //递归的向上找，直到找到代表节点。最后返回代表节点，然后再回退之前走的路径上的每个节点，
									// 回退的过程中，每次都返回代表节点，把每个节点的父节点都变成代表节点，也就是优化变扁平的过程；
			}
			fatherMap.put(node, father);
			return father;
		}

		// 迭代版本
		private Node findHead1(Node node) {
			Stack<Node> stack = new Stack<Node>();

			Node cur = node;
			Node patent = fatherMap.get(cur);
			while (cur != patent){
				stack.push(cur);
				cur = patent;
				patent = fatherMap.get(cur);
			}

			while (!stack.isEmpty()){
				fatherMap.put(stack.pop(),patent);
			}
			return patent;
		}

		//对外功能
		public boolean isSameSet(Node a, Node b) {
			return findHead(a) == findHead(b);
		}

		//对外功能
		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aHead = findHead(a);
			Node bHead = findHead(b);
			if (aHead != bHead) {
				int aSetSize= sizeMap.get(aHead);  // 获取一个集合的size的时候，只通过head代表节点去获取的
				int bSetSize = sizeMap.get(bHead);
				if (aSetSize <= bSetSize) {
					fatherMap.put(aHead, bHead);	//把A的头结点指向B集合的head，就是把A集合挂在B集合上
					//修改size的时候，只需要修改头结点的size就可以，因为得到size的时候，就是通过代表节点作为key去获取的
					sizeMap.put(bHead, aSetSize + bSetSize);  // B集合的size变大
				} else {
					fatherMap.put(bHead, aHead);
					sizeMap.put(aHead, aSetSize + bSetSize);
				}
			}
		}
	}
}

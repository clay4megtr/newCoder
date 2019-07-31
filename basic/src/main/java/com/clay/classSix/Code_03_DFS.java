package com.clay.classSix;

import java.util.HashSet;
import java.util.Stack;

public class Code_03_DFS {

	public static void dfs(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		HashSet<Node> set = new HashSet<>();  // 也是标记这个节点有没有进过栈
		stack.add(node);
		set.add(node);
		System.out.println(node.value);  // 上来就打印

		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			for (Node next : cur.nexts) {
				if (!set.contains(next)) {  // 只要发现一个邻居节点没有进过栈，//表示后续节点要把所有能走的路都走过，
					stack.push(cur);   // 但是break之前，当前节点和
					stack.push(next);  // 下一个邻居节点一起重新回到stack中；
					set.add(next);   //标记这个邻居节点进过栈了；
					System.out.println(next.value);
					break;   // 就直接break，不再找了，
				}
			}
		}
	}
}

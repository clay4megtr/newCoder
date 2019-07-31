package com.clay.classSix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Code_02_BFS {

	public static void bfs(Node node) {
		if (node == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		HashSet<Node> map = new HashSet<>();  //set 表示这个点有没有进过这个队列，set的作用就是不让已经进过队列的节点再次进入；
		queue.add(node);
		map.add(node); // 进过set的就保留下来
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			System.out.println(cur.value);
			for (Node next : cur.nexts) {   //找到这个节点的所有邻居节点
				if (!map.contains(next)) {    // 只要这个节点没有进过队列，
					map.add(next);
					queue.add(next); // 就加入队列中；
				}
			}
		}
	}
}

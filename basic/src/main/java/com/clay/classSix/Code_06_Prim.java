package com.clay.classSix;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// undirected graph only
public class Code_06_Prim {

	public static class EdgeComparator implements Comparator<Edge> {
		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}
	}

	public static Set<Edge> primMST(Graph graph) {
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
		HashSet<Node> set = new HashSet<>();
		Set<Edge> result = new HashSet<>();

		//这个for 循环是针对森林设计的，如果只有一张连通图，下面的if足够了；
		for (Node node : graph.nodes.values()) {

			//node: v1
			if (!set.contains(node)) {
				set.add(node);
				for (Edge edge : node.edges) {
					priorityQueue.add(edge);  // node的所有边加入到优先级队列中；
				}
				while (!priorityQueue.isEmpty()) {
					Edge edge = priorityQueue.poll();  // 弹出一个权重最小的边，
					Node toNode = edge.to;  		// 找到这个表的to node，如果一个边已经加过了，它的to node 一定已经加过了，
					if (!set.contains(toNode)) {  // 如果to node不在set中，
						set.add(toNode); 		 // 就加入set中；
						result.add(edge);
						for (Edge nextEdge : toNode.edges) {
							priorityQueue.add(nextEdge); // to node的后续所有边都加到优先级队列中；
						}
					}
				}
			}

		}
		return result;
	}
}

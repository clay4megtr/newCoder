package com.clay.classSix;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//undirected graph only
public class Code_05_Kruskal {

	// 并查集的原理之前已经总结过，忘了就看一下之前的博客
	public static class UnionFind {
		private HashMap<Node, Node> fatherMap;
		private HashMap<Node, Integer> rankMap;

		public UnionFind() {
			fatherMap = new HashMap<Node, Node>();
			rankMap = new HashMap<Node, Integer>();
		}

		private Node findFather(Node n) {
			Node father = fatherMap.get(n);
			if (father != n) {
				father = findFather(father);
			}
			fatherMap.put(n, father);
			return father;
		}

		public void  makeSets(Collection<Node> nodes) {
			fatherMap.clear();
			rankMap.clear();
			for (Node node : nodes) {
				fatherMap.put(node, node);
				rankMap.put(node, 1);
			}
		}

		public boolean isSameSet(Node a, Node b) {
			return findFather(a) == findFather(b);
		}

		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aFather = findFather(a);
			Node bFather = findFather(b);
			if (aFather != bFather) {
				int aFrank = rankMap.get(aFather);
				int bFrank = rankMap.get(bFather);
				if (aFrank <= bFrank) {
					fatherMap.put(aFather, bFather);
					rankMap.put(bFather, aFrank + bFrank);
				} else {
					fatherMap.put(bFather, aFather);
					rankMap.put(aFather, aFrank + bFrank);
				}
			}
		}
	}

	public static class EdgeComparator implements Comparator<Edge> {
		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}
	}

	public static Set<Edge> kruskalMST(Graph graph) {
		UnionFind unionFind = new UnionFind();
		unionFind.makeSets(graph.nodes.values());  //所有的节点放进并查集；用来判断是否产生了回路；

		//优先级队列，按照权重小的在前边的顺序；
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());

		for (Edge edge : graph.edges) {  // 都放进优先级队列中；
			priorityQueue.add(edge);
		}

		Set<Edge> result = new HashSet<>();
		while (!priorityQueue.isEmpty()) {
			Edge edge = priorityQueue.poll();  //每次从小根堆中弹出一个边，
			if (!unionFind.isSameSet(edge.from, edge.to)) {  // 如果选择这条边之后，from节点和to节点就属于同一个集合了，就不要这条边了，因为有回路了
				result.add(edge);  // 否则：就要这条边，
				unionFind.union(edge.from, edge.to);  // 然后把这个边的from节点和to节点所在的集合合并，
			}
		}
		return result;
	}
}

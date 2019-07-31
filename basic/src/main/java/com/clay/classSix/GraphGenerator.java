package com.clay.classSix;

public class GraphGenerator {

	// 每一行就是长度为3的数组；[权重，from，to]
	public static Graph createGraph(Integer[][] matrix) {
		Graph graph = new Graph();
		for (int i = 0; i < matrix.length; i++) {
			Integer weight = matrix[i][0];
			Integer from = matrix[i][1];
			Integer to = matrix[i][2];

			//如果不包含from点和to点，建立两个节点
			if (!graph.nodes.containsKey(from)) {
				graph.nodes.put(from, new Node(from));
			}
			if (!graph.nodes.containsKey(to)) {
				graph.nodes.put(to, new Node(to));
			}

			//拿出from点，to点，建立一个新的边；
			Node fromNode = graph.nodes.get(from);
			Node toNode = graph.nodes.get(to);
			Edge newEdge = new Edge(weight, fromNode, toNode);

			// 一个节点的内容包括：入度，出度，后续邻居节点，发散出的边，
			// 所以：from节点三个往下走的都需要变化：出度，后续邻居节点，发散出的边，
			//      to节点只需要变化一个：入度
			fromNode.nexts.add(toNode);   //  from节点的后续节点新增一个to节点
			fromNode.out++;				  //  from节点的out出度+1
			toNode.in++;				  //  to节点的入度+1
			fromNode.edges.add(newEdge);  //  从from节点发散出的边增加一条
			graph.edges.add(newEdge);	  //  整个图的边新增一条
		}
		return graph;
	}
}

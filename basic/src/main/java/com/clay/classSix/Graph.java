package com.clay.classSix;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
	public HashMap<Integer,Node> nodes;  //  <点对应的value值，实际对应的节点>
	public HashSet<Edge> edges; 		 //  所有的边的集合

	public Graph() {
		nodes = new HashMap<>();
		edges = new HashSet<>();
	}
}

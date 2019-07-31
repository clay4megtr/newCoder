package com.clay.classSix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code_04_TopologySort {

	// directed graph and no loop
	public static List<Node> sortedTopology(Graph graph) {

		HashMap<Node, Integer> inMap = new HashMap<>(); //统计所有节点的入度

		Queue<Node> zeroInQueue = new LinkedList<>();  //入度为0的点，进入这个队列

		for (Node node : graph.nodes.values()) {  //遍历所有的点，
			inMap.put(node, node.in);		//把每个点的入度，登记在map中；
			if (node.in == 0) {
				zeroInQueue.add(node); // 如果这个节点的入度为0，就加入0入度队列中；
			}
		}
		List<Node> result = new ArrayList<>();

		while (!zeroInQueue.isEmpty()) {
			Node cur = zeroInQueue.poll();  //从0入度队列中，拿出一个节点，
			result.add(cur);				//加入结果链表中；
			for (Node next : cur.nexts) {  			//找到这个节点的所有后续邻居节点；
				inMap.put(next, inMap.get(next) - 1);  //把这个节点的后续邻居节点的入度都-1；
				if (inMap.get(next) == 0) {  	//如果这个邻居节点的入度减完之后变成0了，
					zeroInQueue.add(next);  	//就放进入度为0的队列中；
				}
			}
		}
		return result;
	}
}

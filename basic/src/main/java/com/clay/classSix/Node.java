package com.clay.classSix;

import java.util.ArrayList;

public class Node {

	public int value; //点代表的值

	public int in;  //入度
	public int out; // 出度
	public ArrayList<Node> nexts;   //从我出发能够到达的节点，邻居节点
	public ArrayList<Edge> edges;   //从我出发，能够发散出边的集合；

	public Node(int value) {
		this.value = value;
		in = 0;
		out = 0;
		nexts = new ArrayList<>();
		edges = new ArrayList<>();
	}
}

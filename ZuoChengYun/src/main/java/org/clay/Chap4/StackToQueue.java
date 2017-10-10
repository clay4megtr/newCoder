package org.clay.Chap4;

import java.util.Stack;

public class StackToQueue {

	Stack<Integer> stackIn = new Stack<Integer>();
	Stack<Integer> stackOut = new Stack<Integer>();

	public void push(int node) {

		//如果push的时候，第二个栈中还有元素，就先把第二个栈中的元素出栈，放回第一个栈中，
		while (!stackOut.isEmpty()) {

			Integer pop = stackOut.pop();
			stackIn.push(pop);
		}

		stackIn.push(node);
	}

	public int pop() {

		//如果pop的时候，第一个栈中还有元素，就先把第一个栈中的元素全部出栈，放到第二个栈中。
		while (!stackIn.isEmpty()) {

			Integer pop = stackIn.pop();
			stackOut.push(pop);
		}
		return stackOut.pop();
	}

	public static void main(String[] args) {
		StackToQueue stq = new StackToQueue();
		stq.push(1);
		stq.push(2);
		stq.push(3);
		stq.pop();
		stq.pop();
		stq.push(4);
		stq.pop();
		stq.push(5);
		stq.pop();
		stq.pop();
	}
}

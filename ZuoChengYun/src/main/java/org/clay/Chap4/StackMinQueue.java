package org.clay.Chap4;

import java.util.Stack;

/**
 * 实现特殊栈，getMin操作
 * @author clay
 */
public class StackMinQueue {

	Stack<Integer> stackData = new Stack<>();
	Stack<Integer> stackMin = new Stack<>();
	
	public void pop(){
		stackData.pop();
		stackMin.pop();
	}
	
	//将当前元素压入栈
	public void push(int node){
		stackData.push(node);
		
		/**
		 * 如果最小栈为空，那么直接压入
		 * 否则如果当前元素小于stackMin的顶部元素，直接压入，大于就继续压入stackMin的顶部元素
		 */
		if(stackMin.isEmpty()){
			stackMin.push(node);
		}else{
			if(node < stackMin.peek().intValue()){
				 stackMin.push(node);
			}else{
				stackMin.push(stackMin.peek());
			}
		}
	}
	
	public int getMin(){
		return stackMin.peek();
	}
}

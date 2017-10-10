package org.clay.Chap4;

import java.util.Stack;

/**
 * 实现栈的逆序操作，
 * 只能使用递归操作和这个栈本身的操作
 * @author clay
 */
public class ReverseStack {
	/**
	 * 返回并移除栈底元素
	 */
	public int get(Stack<Integer> stack){
	
		Integer res = stack.pop();
		
		if(stack.isEmpty()){
			return res;
		}else{
			int last = get(stack);
			stack.push(res);
			return last;
		}
	}
	/**
	 * 整个栈的逆序操作，
	 */
	public void reverse(Stack<Integer> stack){
		if(stack.isEmpty()){
			return;
		}
		int i = get(stack);
		reverse(stack);
		stack.push(i);
	}
}

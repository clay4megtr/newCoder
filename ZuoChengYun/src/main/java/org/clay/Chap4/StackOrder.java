package org.clay.Chap4;

import java.util.Stack;

/**
 * 将该栈从顶到底按从大到小排序
 * 只允许申请一个栈，
 * 可以申请变量
 * 但是不能申请其他数据结构
 * @author clay
 */
public class StackOrder {

	/**
	 * 每次从栈中拿出一个和help中的比，比help中的小就直接放入，比help中的大，就先拿出来，把help中的全倒回stack中，再把这个值放进help
	 * 目的就是把help中的值从小到大排序，
	 * 最后把help中的全部值倒回stack，就是从大到小排列的。
	 * @param stack
	 */
	public void stackOrder(Stack<Integer> stack){
		
		Stack<Integer> help = new Stack<>();
		while(!stack.isEmpty()){
			
			Integer cur = stack.pop();
			if(help.isEmpty()){
				help.push(cur);
			}else{
				if(cur <= help.peek()){
					help.push(cur);
				}else{
					//比help的栈顶元素大
					while(!help.isEmpty()){
						stack.push(help.pop());
					}
					help.push(cur);
				}
			}
		}
		
		while(!help.isEmpty()){
			stack.push(help.pop());
		}
	}
	
	public static void main(String[] args) {
		
		StackOrder so = new StackOrder();
		
		Stack<Integer> stack = new Stack<>();
		stack.push(2);
		stack.push(1);
		stack.push(5);
		stack.push(4);
		stack.push(3);
		so.stackOrder(stack);
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}
}

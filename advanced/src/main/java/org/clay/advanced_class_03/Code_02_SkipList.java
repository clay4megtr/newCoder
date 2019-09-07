package org.clay.advanced_class_03;

import java.util.ArrayList;
import java.util.Iterator;

public class Code_02_SkipList {

	public static class SkipListNode {
		public Integer value;
		//长度为10，说明有10层，nextNodes[1]代表在1层上他的下一个节点是什么
		//0层指向null，1指向第一层他的下一个结点是谁，以此类推
		//从高层到下
		public ArrayList<SkipListNode> nextNodes;

		public SkipListNode(Integer value) {
			this.value = value;
			nextNodes = new ArrayList<SkipListNode>();
		}
	}

	public static class SkipListIterator implements Iterator<Integer> {
		SkipList list;
		SkipListNode current;

		public SkipListIterator(SkipList list) {
			this.list = list;
			this.current = list.getHead();
		}

		public boolean hasNext() {
			return current.nextNodes.get(0) != null;
		}

		public Integer next() {
			current = current.nextNodes.get(0);
			return current.value;
		}
	}

	public static class SkipList {
		private SkipListNode head;//巨小，层数是最高的
		private int maxLevel;
		private int size;//加进来了多少个key
		private static final double PROBABILITY = 0.5;

		public SkipList() {
			size = 0;
			maxLevel = 0;
			head = new SkipListNode(null);
			head.nextNodes.add(null);
		}

		public SkipListNode getHead() {
			return head;
		}

		public void add(Integer newValue) {
			if (!contains(newValue)) {
				size++;
				int level = 0;
				while (Math.random() < PROBABILITY) {
					level++;
				}
				while (level > maxLevel) {
					head.nextNodes.add(null);//头增加区域到最大层数
					maxLevel++;
				}
				SkipListNode newNode = new SkipListNode(newValue);
				SkipListNode current = head;//从头部往下移动
				int levelAll = maxLevel;//从最高层开始找
				do {
					current = findNext(newValue, current, levelAll);
					if (levelAll <= level){//达到应该加入节点的层
						//前后环境接上
						//当前层，建立指向刚好比自己大的节点的联系
						//例如一共5层，由于是从高层开始插入，先把第五层加入0位置
						//接着第四层的时候也是加到0位置，那就把原本第五层的挤到1位置
						//...以此类推，加到最后一层就会是正常的0位置
						// 最后一层也已经被挤到最后的位置上
						newNode.nextNodes.add(0, current.nextNodes.get(level));
						//把刚好比他小的节点，指向他。例如：7--->10 加入8 变成7--->8--->10
						current.nextNodes.set(level, newNode);
						level--;
					}

				} while (levelAll-- > 0);//当前层小了往右，大了往下
			}
		}

		public void delete(Integer deleteValue) {
			if (contains(deleteValue)) {
				SkipListNode deleteNode = find(deleteValue);
				size--;
				int level = maxLevel;
				SkipListNode current = head;
				do {
					current = findNext(deleteNode.value, current, level);
					if (deleteNode.nextNodes.size() > level) {
						current.nextNodes.set(level, deleteNode.nextNodes.get(level));
					}
				} while (level-- > 0);
			}
		}

		// Returns the skiplist node with greatest value <= e
		private SkipListNode find(Integer e) {
			return find(e, head, maxLevel);
		}

		// Returns the skiplist node with greatest value <= e
		// Starts at node start and level
		private SkipListNode find(Integer e, SkipListNode current, int level) {
			do {
				current = findNext(e, current, level);
			} while (level-- > 0);
			return current;
		}

		// Returns the node at a given level with highest value less than e
		private SkipListNode findNext(Integer e, SkipListNode current, int level) {
			//获得当前节点所在层中连接的下一个节点(例如cur在第七层中的下一个)
			SkipListNode next = current.nextNodes.get(level);
			while (next != null) {
				Integer value = next.value;
				if (lessThan(e, value)) { // e < value
					break;//如果下一个数比新增值大了，就找到接入位置。
					//cur就是这一层中，最后一个小于当前数的值。
				}
				//向右动
				current = next;
				next = current.nextNodes.get(level);
			}
			return current;
		}

		public int size() {
			return size;
		}

		public boolean contains(Integer value) {
			SkipListNode node = find(value);
			return node != null && node.value != null && equalTo(node.value, value);
		}

		public Iterator<Integer> iterator() {
			return new SkipListIterator(this);
		}

		/******************************************************************************
		 * Utility Functions *
		 ******************************************************************************/

		private boolean lessThan(Integer a, Integer b) {
			return a.compareTo(b) < 0;
		}

		private boolean equalTo(Integer a, Integer b) {
			return a.compareTo(b) == 0;
		}

	}

	public static void main(String[] args) {

	}

}

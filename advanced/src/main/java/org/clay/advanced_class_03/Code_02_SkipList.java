package org.clay.advanced_class_03;

import java.util.ArrayList;
import java.util.Iterator;

public class Code_02_SkipList {

	public static class SkipListNode {  //调表的Node结构
		public Integer value;
		public ArrayList<SkipListNode> nextNodes;  // size层数，nextNodes[0]：在第0层的下一个节点

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
		private SkipListNode head;  //巨小
		private int maxLevel; //最大层数，记录的是所有数据扔出来的最大层数
		private int size;  //加进来了多少个key
		private static final double PROBABILITY = 0.5;  // 以什么概率出0，以1-这个概率出1

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
				int level = 1;
				while (Math.random() < PROBABILITY) {
					level++;  //扔骰子决定层数
				}
				// update max level
				if (level > maxLevel) {
					int increment = level - maxLevel;
					while (increment-- > 0) {
						this.head.nextNodes.add(null);
					}
					maxLevel = level;//head 的 maxLevel 永远记录最大层数
				}
				SkipListNode newNode = new SkipListNode(newValue);  //新的值
				SkipListNode current = findInsertionOfTopLevel(newValue, level);

				while (level > 0) {	//一层一层找， 一定会一直找到第0层，每一层找到两个点接上，

					//下面6行代码就是让前后环境接上，
					if (current.nextNodes.get(level) != null) {
						newNode.nextNodes.add(0, current.nextNodes.get(level));//每次放到0位置，下一次循环0位置的值会被怼到1位置，依次往上怼，最终的结果就是正确的
					} else {
						newNode.nextNodes.add(0, null);
					}
					current.nextNodes.set(level, newNode); //current的每一层接到新的newNode，
					level--;

					//注意这个 current 每一层可能都不一样，因为上一个current后面可能有层数更低的节点
					//这一层中最后一个小于当前数的，
					current = findNext(newValue,current,level);

				}
				newNode.nextNodes.add(0, null);
				size++;
			}
		}

		public void delete(int value) {
			//if exists
			if (contains(value)) {
				//find the node and its level
				SkipListNode deletedNode = head;
				int deletedLevels = maxLevel;
				//because exists,so must can find
				while (deletedLevels > 0) {
					if (deletedNode.nextNodes.get(deletedLevels) != null) {
						if (deletedNode.nextNodes.get(deletedLevels).value == value) {
							deletedNode = deletedNode.nextNodes.get(deletedLevels);
							break;
						} else if (deletedNode.nextNodes.get(deletedLevels).value < value) {
							deletedNode = deletedNode.nextNodes.get(deletedLevels);
						} else {
							deletedLevels--;
						}
					} else {
						deletedLevels--;
					}
				}
				//release the node and adjust the reference
				while (deletedLevels > 0) {
					SkipListNode pre = findInsertionOfTopLevel(value, deletedLevels);
					if (deletedNode.nextNodes.get(deletedLevels) != null) {
						pre.nextNodes.set(deletedLevels, deletedNode.nextNodes.get(deletedLevels));
					} else {
						pre.nextNodes.set(deletedLevels, null);
					}
					deletedLevels--;
				}

				size--;
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

		private SkipListNode findInsertionOfTopLevel(int newValue, int level) {
			int curLevel = this.maxLevel;
			SkipListNode cur = head;
			while (curLevel >= level) {
				if (cur.nextNodes.get(curLevel) != null
						&& cur.nextNodes.get(curLevel).value < newValue) {
					// go right
					cur = cur.nextNodes.get(curLevel);
				} else {
					// go down
					curLevel--;
				}
			}
			return cur;
		}


		// Returns the node at a given level with highest value less than e

		/**
		 * @param e   新的值
		 * @param current	当前的节点
		 * @param level   在第level层找，
		 *
		 */
		private SkipListNode findNext(Integer e, SkipListNode current, int level) {
			SkipListNode next = current.nextNodes.get(level); //在当前层的下一个Node
			while (next != null) {
				Integer value = next.value;
				if (lessThan(e, value)) { //当前值小于拿出来的next的值，
					break;//找到了，直接返回current
				}
				current = next; //没找到，继续往右走，
				next = current.nextNodes.get(level);
			}
			return current; //可以理解为这一层中最后一个小于当前数的；
		}

		public int size() {
			return size;
		}

		public boolean contains(int value) {
			if (this.size == 0) {
				return false;
			}
			SkipListNode cur = head;
			int curLevel = maxLevel;
			while (curLevel > 0) {
				if (cur.nextNodes.get(curLevel) != null) {
					if (cur.nextNodes.get(curLevel).value == value) {
						return true;
					} else if (cur.nextNodes.get(curLevel).value < value) {
						cur = cur.nextNodes.get(curLevel);
					} else {
						curLevel--;
					}
				} else {
					curLevel--;
				}
			}

			return false;
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

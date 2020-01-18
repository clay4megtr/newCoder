package org.clay.advanced_class_04;

import java.util.HashMap;

/**
 * 总是忘记怎么做的原因其实是要注意把用户的value 包装成一个 Node类型，双向链表中存的是这个Node类型；
 *
 * 核心点在于这个双向链表
 * 更核心的是这个双向链表的moveNodeToTail方法，这个方法会把一个Node类型节点移到尾部，尾部的优先级更高；
 * 也就是把优先级这个事交给双向链表这个结构来做；
 */
public class Code_02_LRU {

	public static class Node<V> {
		public V value;
		public Node<V> last;
		public Node<V> next;

		public Node(V value) {
			this.value = value;
		}
	}

	public static class NodeDoubleLinkedList<V> {
		private Node<V> head;  //头指针
		private Node<V> tail;   //尾指针

		public NodeDoubleLinkedList() {
			this.head = null;
			this.tail = null;
		}

		//新增节点
		public void addNode(Node<V> newNode) {
			if (newNode == null) {
				return;
			}
			if (this.head == null) { //第一个节点
				this.head = newNode;
				this.tail = newNode;
			} else {
				this.tail.next = newNode; //
				newNode.last = this.tail;
				this.tail = newNode;
			}
		}

		//移动节点到尾部，尾部的优先级高
		public void moveNodeToTail(Node<V> node) {
			if (this.tail == node) { //尾节点不用动
				return;
			}
			if (this.head == node) {  //头节点
				this.head = node.next;
				this.head.last = null;
			} else {
				node.last.next = node.next;
				node.next.last = node.last;
			}
			node.last = this.tail;
			node.next = null;
			this.tail.next = node;
			this.tail = node;
		}

		//移除头部
		public Node<V> removeHead() {
			if (this.head == null) {
				return null;
			}
			Node<V> res = this.head;
			if (this.head == this.tail) { //只有一个节点
				this.head = null;
				this.tail = null;
			} else {
				this.head = res.next;
				res.next = null;
				this.head.last = null;
			}
			return res;
		}
	}

	public static class MyCache<K, V> {
		private HashMap<K, Node<V>> keyNodeMap;
		private HashMap<Node<V>, K> nodeKeyMap;
		private NodeDoubleLinkedList<V> nodeList;
		private int capacity;

		public MyCache(int capacity) {
			if (capacity < 1) {
				throw new RuntimeException("should be more than 0.");
			}
			this.keyNodeMap = new HashMap<K, Node<V>>();
			this.nodeKeyMap = new HashMap<Node<V>, K>();
			this.nodeList = new NodeDoubleLinkedList<V>();
			this.capacity = capacity;
		}

		/**
		 * 获取数据时，直接从map中取，然后在双向链表中把这个Node移动到尾部
		 */
		public V get(K key) {
			if (this.keyNodeMap.containsKey(key)) {
				Node<V> res = this.keyNodeMap.get(key);
				this.nodeList.moveNodeToTail(res);
				return res.value;
			}
			return null;
		}

		/**
		 * 设置数据时，先从map中取，
		 * 1.如果map中有，就赋值，然后把value移动到双向链表的末尾
		 * 2.如果map中没有，就放到map中，然后加到双向链表的末尾，注意此时要判断容量是否超了；超了的话要移除头部，
		 */
		public void set(K key, V value) {
			if (this.keyNodeMap.containsKey(key)) {
				Node<V> node = this.keyNodeMap.get(key);
				node.value = value;
				this.nodeList.moveNodeToTail(node);
			} else {
				Node<V> newNode = new Node<V>(value);
				this.keyNodeMap.put(key, newNode);
				this.nodeKeyMap.put(newNode, key);
				this.nodeList.addNode(newNode);
				if (this.keyNodeMap.size() == this.capacity + 1) {
					this.removeMostUnusedCache();
				}
			}
		}

		private void removeMostUnusedCache() {
			Node<V> removeNode = this.nodeList.removeHead();
			K removeKey = this.nodeKeyMap.get(removeNode);  //这里展示出了nodeKeyMap的作用，是为了更方便的找到key，然后从keyNodeMap中移除
			this.nodeKeyMap.remove(removeNode);
			this.keyNodeMap.remove(removeKey);
		}

	}

	public static void main(String[] args) {
		MyCache<String, Integer> testCache = new MyCache<String, Integer>(3);
		testCache.set("A", 1);
		testCache.set("B", 2);
		testCache.set("C", 3);
		System.out.println(testCache.get("B"));
		System.out.println(testCache.get("A"));
		testCache.set("D", 4);
		System.out.println(testCache.get("D"));
		System.out.println(testCache.get("C"));
	}
}

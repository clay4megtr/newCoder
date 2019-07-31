package org.clay.advanced_class_04;

import java.util.HashMap;

public class Code_03_LFU {

    public static class Node { //次数链表下面挂的小链表
        public Integer key;
        public Integer value;
        public Integer times;  //次数
        public Node up;   //双向链表
        public Node down;

        public Node(int key, int value, int times) {
            this.key = key;
            this.value = value;
            this.times = times;
        }
    }

    public static class LFUCache {

        public static class NodeList { //一个次数链表的头+下面挂的子双向链表，就是竖着的一串；
            public Node head;
            public Node tail;
            public NodeList last;   //下一个竖着的链表，
            public NodeList next;

            public NodeList(Node node) { //必修给一个Node，才能创建NodeList，
                head = node;
                tail = node;
            }

            //新增的时候加到头部，说明头部是最新的；和讲的有些不一致，讲的是新增到尾部，一个意思；
            public void addNodeFromHead(Node newHead) {
                newHead.down = head;
                head.up = newHead;
                head = newHead;
            }

            public boolean isEmpty() {
                return head == null;
            }

            //删除一个节点，get或put一个节点的时候，要从一个NodeList删除，然后加到新的NodeList中
            public void deleteNode(Node node) {
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    if (node == head) {
                        head = node.down;
                        head.up = null;
                    } else if (node == tail) {
                        tail = node.up;
                        tail.down = null;
                    } else {
                        node.up.down = node.down;
                        node.down.up = node.up;
                    }
                }
                node.up = null;
                node.down = null;
            }
        }

        private int capacity;  //容量。
        private int size;   // 当前大小
        private HashMap<Integer, Node> records; // key(Integer) -> Node
        private HashMap<Node, NodeList> heads;  //get的时候要查询一个Node属于哪个NodeList，就是找头，
        private NodeList headList;  //整个结构中第一个 NodeList 是谁， 整个结构由多个NodeList组成

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.records = new HashMap<>();
            this.heads = new HashMap<>();
            headList = null;
        }

        // 核心逻辑
        public void set(int key, int value) {
            if (records.containsKey(key)) { //说明之前加过
                Node node = records.get(key);
                node.value = value;
                node.times++;
                NodeList curNodeList = heads.get(node); //属于哪个NodeList，
                move(node, curNodeList); //从原来的NodeList中删除，放到下一个 NodeList 上；
            } else {  //新的节点
                if (size == capacity) {  //需要删除了
                    //找到该删的节点，都删除，并消除它的影响。
                    Node node = headList.tail;  // headList 的尾节点是需要删除的，因为新增的时候是新增到头部的；
                    headList.deleteNode(node);
                    modifyHeadList(headList);//如果这个headList为空了，需要把headList换成新的；
                    records.remove(node.key);
                    heads.remove(node);
                    size--;
                }
                Node node = new Node(key, value, 1);//新节点
                if (headList == null) {     //整个大结构都没有生成
                    headList = new NodeList(node);
                } else {
                    if (headList.head.times.equals(node.times)) {  //看有没有词频为1的头节点
                        headList.addNodeFromHead(node);
                    } else {                                    //没有的话需要新建出来一个词频为1的头节点headList；
                        NodeList newList = new NodeList(node);
                        newList.next = headList;
                        headList.last = newList;
                        headList = newList;
                    }
                }
                records.put(key, node);
                heads.put(node, headList);
                size++;
            }
        }

        /**
         * 把 @param node 从老的 @param oldNodeList 移动到新的nodelist上
         */
        private void move(Node node, NodeList oldNodeList) {
            oldNodeList.deleteNode(node);

            //node 即将进入一个新的nodelist中，那么这个新的nodelist 的上一个链表是谁呢？如果oldNodeList删完之后没有元素了，那么
            //上一个链表就是oldNodeList的上一个nodelist，否则就是oldNodeList本身，
            NodeList preList = modifyHeadList(oldNodeList) ? oldNodeList.last
                    : oldNodeList;
            //新的nodelist的下一个nodelist
            NodeList nextList = oldNodeList.next;
            if (nextList == null) {     //说明oldNodeList就是整个结构的尾部，这个node的词频加完之后是最高的
                NodeList newList = new NodeList(node);

                //下面两个if其实就是前后重连的意思，
                if (preList != null) {
                    preList.next = newList;
                }
                newList.last = preList;
                if (headList == null) {
                    headList = newList;
                }
                heads.put(node, newList);
            } else {        //说明oldNodeList不是整个结构的尾部，此时就需要nodelist之间的前后重连了
                if (nextList.head.times.equals(node.times)) {  //下一个nodelist正好是次数+1的
                    nextList.addNodeFromHead(node); //直接挂在nextList的头部
                    heads.put(node, nextList);
                } else {
                    NodeList newList = new NodeList(node);  //下一个nodelist是更大的，需要在中间加一个，需要重连；
                    if (preList != null) {
                        preList.next = newList;
                    }
                    newList.last = preList;
                    newList.next = nextList;
                    nextList.last = newList;
                    if (headList == nextList) {
                        headList = newList;
                    }
                    heads.put(node, newList);
                }
            }
        }

        // delete完之后，是否需要把整个链表都删掉；
        private boolean modifyHeadList(NodeList nodeList) {
            if (nodeList.isEmpty()) {  // 如果当前nodeList为空了，就删掉这个 NodeList
                if (headList == nodeList) { // 是否是整个结构的头部，需要换头
                    headList = nodeList.next;
                    if (headList != null) {
                        headList.last = null;
                    }
                } else {
                    //删除当前nodelist，然后重连 nodelist
                    nodeList.last.next = nodeList.next;
                    if (nodeList.next != null) {
                        nodeList.next.last = nodeList.last;
                    }
                }
                return true;
            }
            return false;
        }

        public Integer get(int key) {
            if (!records.containsKey(key)) {
                return null;  // 不存在
            }
            Node node = records.get(key);
            node.times++;
            NodeList curNodeList = heads.get(node);
            move(node, curNodeList); //从原来的NodeList中删除，放到下一个 NodeList 上；
            return node.value;
        }
    }
}
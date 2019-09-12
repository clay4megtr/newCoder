package org.clay.test3;

import java.util.HashMap;
import java.util.Map;

public class LRUChche {


    public static class Node<K,V>{
        private K key;
        private V value;
        private Node last;
        private Node next;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 自定义双向链表
     * 从头部删，从尾部加
     * 有头、尾指针，可以删除头结点，
     * 把某一个结点放到尾部；
     */
    public static class MyLinkedList<K,V>{

        private Node<K,V> head;
        private Node<K,V> tail;

        public void append(Node<K,V> node){

            if(head == null){
                this.head = node;
                this.tail = node;
            }else{
                node.last = tail;
                this.tail.next = node;
                this.tail = node;
            }
        }

        //把node结点移到尾部，结点肯定存在
        public void removeNode2Tail(Node<K,V> node){
            if(this.tail == node){  //已经是尾部
                return;
            }

            if(node == head){  //node是头结点，需要特殊处理
                this.head = node.next;
                node.next.last = null;
            }else{  //普通情况
                node.next.last = node.last;
                node.last.next = node.next;
            }
            node.next = null;
            node.last = this.tail;
            this.tail.next = node;
            this.tail = node;
        }

        //删除并返回头结点
        public Node<K,V> removeHead(){

            Node<K,V> tmp = this.head;
            if(this.head == this.tail){
                this.head = null;
                this.tail = null;
            }else{
                this.head = this.head.next; //头指针指向下一个
                this.head.last = null;
            }
            return tmp;
        }

    }

    public static class MyLRUChche<K,V>{

        private Map<K,Node<K,V>> map;
        private Integer size;
        private Integer threshold;
        private MyLinkedList<K,V> linkedList;

        public MyLRUChche(int threshold){
            map = new HashMap<>();
            this.size = 0;
            this.threshold = threshold;
            this.linkedList = new MyLinkedList<>();
        }

        public void add(K k,V v){
            if(map.containsKey(k)){
                Node<K,V> node = map.get(k);
                node.value = v;
                linkedList.removeNode2Tail(node);
            }else{
                Node node = new Node(k,v);
                map.put(k,node);
                linkedList.append(node);
                this.size++;
                if(this.size == threshold+1){
                    Node<K,V> head = linkedList.removeHead();
                    this.map.remove(head.key);
                }
            }
        }

        public V get(K k){
            if(this.map.containsKey(k)){
                Node<K,V> node = map.get(k);
                linkedList.removeNode2Tail(node);
                return node.value;
            }
            return null;
        }
    }

    public static void main(String[] args) {

        MyLRUChche<String,Integer> chche = new MyLRUChche(3);

        chche.add("a",1);
        chche.add("b",2);
        chche.add("c",3);

        chche.get("a");//bca 低 -> 高
        chche.add("d",4); //cad

        System.out.println(chche.get("b"));
    }
}

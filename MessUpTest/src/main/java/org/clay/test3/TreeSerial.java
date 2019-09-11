package org.clay.test3;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeSerial {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void serial(Node head, Queue<String> list){

        if(head == null){
            list.add("#");
        }else{
            list.add(String.valueOf(head.value));
            serial(head.left,list);
            serial(head.right,list);
        }
    }

    public static Node reSerial(Queue<String> queue){

        String value = queue.poll();
        if(value == "#"){
            return null;
        }else{
            Integer val = Integer.valueOf(value);
            Node cur = new Node(val);
            cur.left = reSerial(queue);
            cur.right = reSerial(queue);
            return cur;
        }
    }

    public static void serial_level(Node head, Queue<String> list){

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur != null){
                list.add(String.valueOf(cur.value));
            }else{
                list.add("#");
            }

            if(cur != null){
                if(cur.left != null){
                    queue.add(cur.left);
                }else{
                    queue.add(null);
                }

                if(cur.right != null){
                    queue.add(cur.right);
                }else{
                    queue.add(null);
                }
            }
        }
    }


    public static Node re_serial_level(Queue<String> queue){

        Node head = new Node(Integer.valueOf(queue.poll()));
        Queue<Node> queue1 = new LinkedList<>();

        queue1.add(head);

        while(!queue1.isEmpty()){

            Node cur = queue1.poll();

            String str = queue.poll();
            if(!str.equals("#")){
                Node left = new Node(Integer.valueOf(str));
                cur.left = left;
                queue1.add(left);
            }else{
                cur.left = null;
            }

            String str1 = queue.poll();
            if(!str1.equals("#")){
                Node right = new Node(Integer.valueOf(str1));
                cur.right = right;
                queue1.add(right);
            }else{
                cur.right = null;
            }

        }

        return head;
    }

    public static void main(String[] args) {
        Node head = null;
        head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        Queue<String> list = new LinkedList<>();
        serial_level(head,list);

        for(String str: list){
            System.out.println(str);
        }

        Node new_head = re_serial_level(list);
        System.out.println("=========");
        System.out.println(new_head.value);
        System.out.println(new_head.left.right.value);
    }
}

package org.clay.test1;

import java.util.LinkedList;
import java.util.Queue;

public class SerialTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int data) { this.value = data; }
    }

    public static String serialTree(Node head){

        if(head == null){
            return "#!";
        }
        String res = head.value + "!";
        res += serialTree(head.left);
        res += serialTree(head.right);

        return res;
    }

    public static Node goujian(String str){
        Queue<String> queue = new LinkedList<>();
        String[] strArr = str.split("!");
        for (String ss: strArr){
            queue.offer(ss);
        }
        return gou(queue);
    }

    private static Node gou(Queue<String> queue) {

        String ss = queue.poll();

        if(ss == "#"){
            return null;
        }
        Node node = new Node(Integer.valueOf(ss));

        node.left = gou(queue);
        node.right = gou(queue);

        return node;
    }

    public static String cengSerial(Node head){

        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        String res = head.value + "!";

        while(!queue.isEmpty()){

            Node node = queue.poll();

            if(node.left != null){
                res += node.left.value + "!";
                queue.offer(node.left);
            }else{
                res += "#!";
            }

            if(node.right != null){
                res += node.right.value + "!";
                queue.offer(node.right);
            }else{
                res += "#!";
            }
        }
        return res;
    }

    public static Node cengFanSerial(String str){

        int index = 0;
        Queue<Node> queue = new LinkedList<>();
        String[] arr = str.split("!");

        Node head = new Node(Integer.valueOf(arr[index++]));

        queue.offer(head);

        while(!queue.isEmpty()){

            Node node = queue.poll();

            node.left = generateNodeByString(arr[index++]);
            node.right = generateNodeByString(arr[index++]);

            if(node.left != null){
                queue.offer(node.left);
            }

            if(node.right != null){
                queue.offer(node.right);
            }
        }


        return null;
    }

    public static Node generateNodeByString(String val) {
        if (val.equals("#")) {
            return null;
        }
        return new Node(Integer.valueOf(val));
    }
}
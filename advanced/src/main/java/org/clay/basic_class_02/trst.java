package org.clay.basic_class_02;

public class trst {

    public static class Node {
        public Node[] nexts = new Node[2]; //0的路还是1的路
    }

    public static void main(String[] args) {

        Node node = new Node();

        System.out.println(node.nexts[0]);
    }
}

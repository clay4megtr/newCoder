package org.clay.test4;

import java.util.HashMap;
import java.util.Map;

/**
 * 二叉树中累加和为aim的最长路径长度
 */
public class MaxPathLength {

    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public static int root(Node head, int aim){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);   //第二个0代表level
        return process(head,0,aim,map,1);
    }

    public static int process(Node head,int cunSum,int aim,Map<Integer,Integer> map,int level){

        if(head == null){
            return Integer.MIN_VALUE;
        }

        int maxLength = Integer.MIN_VALUE;

        cunSum = cunSum + head.value;
        map.putIfAbsent(cunSum, level);

        if(map.get(cunSum - aim) != null){
            maxLength = level - map.get(cunSum - aim);
        }

        int left_res = process(head.left,cunSum,aim,map,level+1);
        int right_res = process(head.right,cunSum,aim,map,level+1);

        if(map.get(cunSum) == level){
            map.remove(cunSum);
        }

        return Math.max(Math.max(left_res,right_res),maxLength);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(1);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(root(head,10));
    }
}

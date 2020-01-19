package org.clay.test4;

import java.util.HashMap;
import java.util.Map;

/**
 * 二叉树中累加和为aim的最长路径长度
 */
public class MaxPathLength {

    static class Node{
        int value;
        PrintTree.Node left;
        PrintTree.Node right;

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

        

        cunSum = cunSum + head.value;


    }
}

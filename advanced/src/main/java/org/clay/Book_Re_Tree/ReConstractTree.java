package org.clay.Book_Re_Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定 先序、中序、后序 三种方式遍历结果，两两结合重构二叉树
 */
public class ReConstractTree{

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 先序和中序结合重构二叉树；
     */
    public static Node preMid2Tree(int[] pre, int[] mid){

        if(pre == null || mid == null){
            return null;
        }

        Map<Integer,Integer> map = new HashMap<>();  //装中序数组中节点值和节点索引的对应关系
        for(int i = 0; i < mid.length; i++){
            map.put(mid[i],i);
        }

        return preMid(pre,0,pre.length-1,mid,0,mid.length-1,map);
    }

    /**
     * @param pre 先序数组
     * @param pi pj 先序数组的取值范围
     * @param mid 中序数组
     * @param mi mj 中序数组的取值范围
     * @param map 中序数组中值和索引的对应关系
     */
    public static Node preMid(int[] pre,int pi,int pj,int[] mid,int mi,int mj,Map<Integer,Integer> map){

        if(pi > pj){
            return null;
        }

        Node head = new Node(pre[pi]); //头结点
        int index = map.get(pre[pi]); //头结点在中序数组中的索引值

        /**
         * pi+1，
         */
        head.left = preMid(pre,pi+1,pi+index-mi,mid,mi,index-1,map);   //

        head.right = preMid(pre,pi+index-mi+1,pj,mid,index+1,mj,map);

        return head;
    }
}

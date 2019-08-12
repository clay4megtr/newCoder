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
     * 先根据先序数组构建头结点，然后在中序数组中找到头节点的索引，这个索引左边的就是左子树中序遍历的数组，右边的就是右子树中序遍历的索引；
     * 从先序遍历的pi+1位置往后移动上面提到索引到中序数组左边界的距离，就是左子树先序遍历的数组，再往后移动上面提到索引到中序数组右边界的距离，就是右子树先序遍历的数组；
     * 先创建头结点，然后递归构建左子树，递归构建右子树，再把构建的头结点返回给上层，
     * 按照这个递归过程一直往下处理即可；
     *
     * 先序：{1,2,4,3,5,7,8,6}
     * 中序：{4,2,1,7,5,8,3,6}
     * 按照这个过程走一遍即可；
     *
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
         * pi+1，左子树先序的左边界肯定是从pi+1开始的，规则如此
         * pi+(index-mi), index-mi是左子树对应的中序数组的长度，pi+左子树对应的长度，就是左子树先序的右边界，
         * mi，左子树的中序数组的左边界从mi开始，
         * index-1，中序数组的右边界到index-1
         */
        head.left = preMid(pre,pi+1,pi+index-mi,mid,mi,index-1,map);   //

        /**
         * 各参数的说明可参照上面的说明
         */
        head.right = preMid(pre,pi+index-mi+1,pj,mid,index+1,mj,map);

        return head;
    }
}

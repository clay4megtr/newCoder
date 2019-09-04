package org.clay.Book_Re_Tree;

import java.util.HashMap;

/**
 * 求一棵二叉树中累加和为给定值的最长路径长度
 * 思路和求一个数组中累加和为给定值的最长子数组的长度一样
 * 都是遍历所有的节点，求解以每个节点结尾的情况下，累加和为给定值的最长路径长度；
 *
 * 注意：不要和求二叉树中最长距离的题弄混，路径指的是从某个节点往下，每次最多选择一个孩子节点，或者不选择所形成的节点链
 */
public class ValueMaxLength {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    /**
     * sumMap: 负责记录从head开始的一条路径上的累加和出现情况；
     * key: 累加和
     * value: 这个累加和在路径中最早出现的层数
     */
    public static int getMaxLength(Node head,int sum){
        HashMap<Integer,Integer> sumMap = new HashMap<>();
        sumMap.put(0,0);  //累加和0不用包括任何节点就可以得到；

        return preOrder(head,sum,0,1,0,sumMap);
    }

    public static int preOrder(Node head,int sum,int preSum,int level,int maxLen,HashMap<Integer,Integer> sumMap){

        if(head == null){
            return maxLen;
        }

        int curSum = preSum + head.value;
        if(!sumMap.containsKey(curSum)){
            sumMap.put(curSum,level);
        }

        if(sumMap.containsKey(curSum - sum)){  //和求最长子数组的思路是一致的，如果加到当前累加值为10，要找累加和为3的子数组的长度，就找之前第一次出现7的,当前层数减去第一次出现7的层数，就是有可能的最大长度
            maxLen = Math.max(level - sumMap.get(curSum - sum),maxLen);
        }

        maxLen = preOrder(head.left,sum,curSum,level+1,maxLen,sumMap);
        maxLen = preOrder(head.right,sum,curSum,level+1,maxLen,sumMap);

        if(level == sumMap.get(curSum)){
            sumMap.remove(curSum);
        }

        return maxLen;
    }
}
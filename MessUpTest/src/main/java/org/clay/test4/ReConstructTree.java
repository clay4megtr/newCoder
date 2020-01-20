package org.clay.test4;

import java.util.HashMap;
import java.util.Map;
import org.clay.test4.PrintTree.Node;

public class ReConstructTree {

    public static Node root(int[] pre,int[] mid){

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < mid.length; i++){
            map.put(mid[i],i);
        }
        return process(pre,0,pre.length-1,mid,0,mid.length-1,map);
    }

    public static Node process(int[] pre,int preStart,int preEnd,int[] mid,int midStart,int midEnd,Map<Integer,Integer> map){

        if(preStart > preEnd){
            return null;
        }

        Node head = new Node(pre[preStart]);
        int index = map.get(pre[preStart]);

        head.left = process(pre,preStart+1,preStart+index-midStart,mid,midStart,index-1,map);
        head.right = process(pre,preStart+index-midStart+1,preEnd,mid,index+1,midEnd,map);
        return head;
    }

    public static void main(String[] args) {

        /*int[] pre = new int[]{1,2,4,5,3,6,7};
        int[] mid = new int[]{4,2,5,1,6,3,7};*/

        int[] pre = new int[]{1,2,6,3,9,5,10};
        int[] mid = new int[]{2,6,1,5,9,3,10};

        PrintTree.levelPrint(root(pre,mid));
    }

}

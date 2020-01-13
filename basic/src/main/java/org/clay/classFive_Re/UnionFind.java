package org.clay.classFive_Re;

import com.sun.jmx.snmp.SnmpOid;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFind {

    public static class Node{
        //whatever you want
    }

    public static class UnionFindSet{
        private HashMap<Node,Node> fatherMap;
        private HashMap<Node,Integer> sizeMap;  //key 只代表 代表节点

        public UnionFindSet(List<Node> nodes){
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();

            for(Node node: nodes){  //只接受一次传递所有参数，不接受变化的情况
                fatherMap.put(node,node);
                sizeMap.put(node,1);
            }
        }

        public Node findHead(Node node){
            Node father = fatherMap.get(node);
            if(node == father){
                return father;
            }
            Node res = findHead(father);
            fatherMap.put(node,res);
            return res;
        }

        public Node findHeadByStack(Node node){
            Stack<Node> stack = new Stack<>();

            Node cur = node;
            Node parent = fatherMap.get(node);

            while(parent != node){
                stack.push(cur);
                cur = parent;
                parent = fatherMap.get(parent);
            }

            while(!stack.isEmpty()){
                fatherMap.put(stack.pop(),parent);
            }
            return parent;
        }

        public void union(Node node1,Node node2){

            Node head1 = findHead(node1);
            Node head2 = findHead(node2);

            if(head1 != head2){
                int size1 = sizeMap.get(head1);
                int size2 = sizeMap.get(head2);

                if(size1 > size2){
                    fatherMap.put(head2,head1);
                    sizeMap.put(head1,size1 + size2);
                }else{
                    fatherMap.put(head1,head2);
                    sizeMap.put(head2,size1 + size2);
                }
            }
        }
    }
}
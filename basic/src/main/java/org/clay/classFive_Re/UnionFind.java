package org.clay.classFive_Re;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFind {

    public static class Node{
        //whatever you want
    }

    public static class UnionFindSet{
        private HashMap<Node,Node> fatherMap;
        private HashMap<Node,Integer> sizeMap;

        public UnionFindSet(List<Node> nodes){
            makeSet(nodes);
        }

        public void makeSet(List<Node> nodes){
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            fatherMap.clear();
            sizeMap.clear();

            for(Node node :nodes){
                fatherMap.put(node,node);
                sizeMap.put(node,1);
            }
        }

        public Node findHead(Node node){
            Node father = fatherMap.get(node);

            while(father != node){
                father = findHead(node);
            }
            fatherMap.put(node,father);
            return father;
        }

        public Node findHead1(Node node){
            Node father = fatherMap.get(node);

            Stack<Node> stack = new Stack<>();

            while(father != node){
                stack.push(node);
                node = father;
                father = fatherMap.get(node);
            }

            while(!stack.isEmpty()){
                fatherMap.put(stack.pop(),father);
            }
            return father;
        }

        public boolean isSameSet(Node a,Node b){
            return findHead(a) == findHead(b);
        }

        public void union(Node a,Node b){
            if(a == null || b == null){
                return;
            }
            Node aHead = findHead(a);
            Node bHead = findHead(b);

            if(aHead != bHead){
                 int aSetSize = sizeMap.get(a);
                 int bSetSize = sizeMap.get(b);
                 if(aSetSize < bSetSize){
                     fatherMap.put(aHead,bHead);
                     sizeMap.put(bHead,aSetSize + bSetSize);
                 }else{
                     fatherMap.put(bHead,aHead);
                     sizeMap.put(aHead,aSetSize + bSetSize);
                 }
            }
        }
    }
}
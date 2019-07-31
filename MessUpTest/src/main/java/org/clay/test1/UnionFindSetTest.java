package org.clay.test1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class UnionFindSetTest {

    public static class UnionFindSet{

        public static class Node{
            //whatever you like
        }

        private Map<Node,Node> fatherMap;
        private Map<Node,Integer> sizeMap;

        public UnionFindSet(List<Node> nodes){
            makeSet(nodes);
        }

        public void makeSet(List<Node> nodes){

            fatherMap = new HashMap();
            sizeMap = new HashMap();
            fatherMap.clear();
            sizeMap.clear();

            for (Node node: nodes){
                fatherMap.put(node,node);
                sizeMap.put(node,1);
            }
        }

        public Node findHead(Node node){
            Node father = fatherMap.get(node);
            if(father != node){
                father = findHead(father);
            }
            fatherMap.put(node,father);

            return father;
        }

        public Node findHead1(Node node){

            Stack<Node> stack = new Stack<>();
            Node parent = fatherMap.get(node);

            while(parent != node) {
                stack.push(node);
                node = parent;
                parent = fatherMap.get(parent);
            }

            while(!stack.isEmpty()){
                Node pop = stack.pop();
                fatherMap.put(pop,parent);
            }

            return parent;
        }


        public boolean isSameSet(Node node1, Node node2){
            return findHead(node1) == findHead(node2);
        }

        public Node union(Node a, Node b){
            if(a == null || b == null){
                return null;
            }
            Node aHead = fatherMap.get(a);
            Node bHead = fatherMap.get(b);

            if(aHead != bHead){

                int aSetSize= sizeMap.get(aHead);  // 获取一个集合的size的时候，只通过head代表节点去获取的
                int bSetSize = sizeMap.get(bHead);

                if(aSetSize <= bSetSize){
                    fatherMap.put(aHead,bHead);
                    sizeMap.put(bHead,aSetSize + bSetSize);
                }else{
                    fatherMap.put(bHead,aHead);
                    sizeMap.put(aHead,aSetSize + bSetSize);
                }
            }
            return null;
        }
    }
}

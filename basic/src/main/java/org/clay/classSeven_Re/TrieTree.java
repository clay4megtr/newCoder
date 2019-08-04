package org.clay.classSeven_Re;

public class TrieTree {

    public static class TrieNode{
        private int path;  //有多少个节点到达过当前节点
        private int end;   //有多少个节点是以当前节点结尾的

        private TrieNode[] nexts;  //后续的路

        public TrieNode(){
            path = 0;
            end = 0;
            nexts = new TrieNode[26];  //强行规定不会出现a-z以外的字母。每一个节点可以有26条路。
        }
    }

    public static class Trie{
        private TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        public void insert(String word){
            if(word == null){
                return;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for(int i = 0; i < chars.length; i++){
                index = chars[i] - 'a';
                if(node.nexts[index] == null){
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.path++;
            }
            node.end++;
        }
    }
}

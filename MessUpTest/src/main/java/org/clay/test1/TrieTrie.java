package org.clay.test1;


public class TrieTrie {

    public static class TrieNode{
        private int path; //有多少 word 走过这个节点
        private int end; //有多少个 word 以它结尾

        private TrieNode[] nexts; //后续节点

        public TrieNode(){
            this.path = 0;
            this.end = 0;
            nexts = new TrieNode[26];
        }
    }

    public static class Trie{

        public static TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        public static void insert(String word){

            char[] arr = word.toCharArray();
            TrieNode node = root;
            for(int i = 0; i < arr.length; i++){
                int index = arr[i] - 'a';
                if(node.nexts[index] == null){
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];//然后把node向下走。
                node.path++;
            }
            node.end++;
        }

        public static int search(String word){
            char[] arr = word.toCharArray();
            TrieNode node = root;
            for(int i = 0; i < arr.length; i++){
                int index = arr[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }

            return node.end;
        }

        public static int preFixNum(String word){
            char[] arr = word.toCharArray();
            TrieNode node = root;
            for(int i = 0; i < arr.length; i++){
                int index = arr[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.path;
        }

        public static void delete(String word){

            char[] arr = word.toCharArray();
            TrieNode node = root;
            for(int i = 0; i < arr.length; i++){
                int index = arr[i] - 'a';
                if(--node.nexts[index].path == 0){
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }

    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.preFixNum("zuo"));
    }
}

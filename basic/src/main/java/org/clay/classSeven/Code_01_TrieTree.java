package org.clay.classSeven;

/**
 * 前缀树
 * 注意：要把字母放在边上！！
 */
public class Code_01_TrieTree {

	public static class TrieNode {
		public int path;//有多少个节点到达过这个节点
		public int end;//有多少个节点是以这个节点结尾的。
		public TrieNode[] nexts;//后续的路。

		public TrieNode() {
			path = 0;
			end = 0;
			nexts = new TrieNode[26];//强行规定不会出现a-z以外的字母。每一个节点可以有26条路。
		}
	}

	public static class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

        /**
         * 插入一个节点。
         */
		public void insert(String word) {
			if (word == null) {
				return;
			}
			char[] chs = word.toCharArray();//"abc" -> [a,b,c]
			TrieNode node = root;//根节点。
			int index = 0;//索引从0开始，
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';               //取出当前char应该位于的索引。
				if (node.nexts[index] == null) {    //判断当前node有没有走向当前字母的路，
					node.nexts[index] = new TrieNode();//如果没有，就建立出来。
				}
				node = node.nexts[index];//然后把node向下走。
				node.path++;//划过的次数+1;
			}
			node.end++;//"abc"这个字符串插入完成后，c上的有多少个字符串以它结尾数据项要+1;
		}

        /**
         * 在trie树中删除"abc" 这个字符串。
         * 往下走的过程中：沿途path--，走到最后end--就行了，
         * 但是在沿途走的过程中，如果发现某一个节点path=0了，那么后续的直接全部删除就行了，不用再向下走了。
         */
		public void delete(String word) {
			if (search(word) != 0) {
				char[] chs = word.toCharArray();
				TrieNode node = root;
				int index = 0;
				for (int i = 0; i < chs.length; i++) {
					index = chs[i] - 'a';
					if (--node.nexts[index].path == 0) {//如果往下
						node.nexts[index] = null;
						return;
					}
					node = node.nexts[index];
				}
				node.end--;
			}
		}

        /**
         * 查找有多少个"abc" 这样的字符串
         */
		public int search(String word) {
			if (word == null) {
				return 0;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {//都没有走向它的路，当然这个字符串肯定就没有出现过。
					return 0;
				}
				node = node.nexts[index];//如果出现过，就继续向下查找。
			}
			return node.end;
		}

        /**
         * 查找有多少个"ab" 这样的字符为起始的。
         */
		public int prefixNumber(String pre) {
			if (pre == null) {
				return 0;
			}
			char[] chs = pre.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.path;
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
		System.out.println(trie.prefixNumber("zuo"));
	}
}
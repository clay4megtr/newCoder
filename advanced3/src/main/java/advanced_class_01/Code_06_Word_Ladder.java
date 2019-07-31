package advanced_class_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Code_06_Word_Ladder {

	public static List<List<String>> findLadders(String beginWord,
			String endWord, List<String> wordList) {
		wordList.add(beginWord);
		HashMap<String, ArrayList<String>> nexts = getNexts(wordList);
		HashMap<String, Integer> distances = getDistances(beginWord, nexts);
		LinkedList<String> pathList = new LinkedList<>();
		List<List<String>> res = new ArrayList<>();
		getShortestPaths(beginWord, endWord, nexts, distances, pathList, res);
		return res;
	}

	/**
	 * 返回一个map，key是单词，value是这个单词的邻居；
	 * @param words  所有的单词
	 * @return
	 */
	public static HashMap<String, ArrayList<String>> getNexts(List<String> words) {
		Set<String> dict = new HashSet<>(words);
		HashMap<String, ArrayList<String>> nexts = new HashMap<>();
		for (int i = 0; i < words.size(); i++) {
			nexts.put(words.get(i), new ArrayList<>());
		}
		for (int i = 0; i < words.size(); i++) {
			nexts.put(words.get(i), getNext(words.get(i), dict));
		}
		return nexts;
	}

	/**
	 * 因为都是a-z，所以这种方式的时间复杂度是O(26L)，而如果采用遍历wordlist中所有的词，来找一个单词的邻居的方式的话，时间复杂度 O(N^2)，
	 * @param word  单词，
	 * @param dict  wordlist 中的词，去重了
	 * @return	word中跟word只有一个字符不一样的单词，全部加入 ArrayList 中
	 */
	private static ArrayList<String> getNext(String word, Set<String> dict) {
		ArrayList<String> res = new ArrayList<String>();
		char[] chs = word.toCharArray();
		for (char cur = 'a'; cur <= 'z'; cur++) {
			for (int i = 0; i < chs.length; i++) {
				if (chs[i] != cur) {
					char tmp = chs[i];
					chs[i] = cur;
					if (dict.contains(String.valueOf(chs))) {
						res.add(String.valueOf(chs));
					}
					chs[i] = tmp;
				}
			}
		}
		return res;
	}

	/**
	 * 宽度优先遍历
	 * @param begin  beginword
	 * @param nexts	 所有单词和它的邻居，是一个map
	 * @return	每个节点距离beginword的距离
	 */
	public static HashMap<String, Integer> getDistances(String begin,
			HashMap<String, ArrayList<String>> nexts) {
		//key: 单词，value：距离beginword的距离
		HashMap<String, Integer> distances = new HashMap<>();
		distances.put(begin, 0);
		Queue<String> queue = new LinkedList<String>();  //BFS 用队列
		queue.add(begin);
		HashSet<String> isVisited = new HashSet<String>(); //不要重复遍历
		isVisited.add(begin);
		while (!queue.isEmpty()) {
			String cur = queue.poll();
			for (String str : nexts.get(cur)) {
				if (!isVisited.contains(str)) {
					distances.put(str, distances.get(cur) + 1);
					queue.add(str);
					isVisited.add(str);
				}
			}
		}
		return distances;
	}

	/**
	 * 搜索的过程就是dfs的过程；
	 * 从cur出发，一路搜下去，看能不能搜到end
	 * @param cur	当前单词		可变
	 * @param end	endwork		不可变
	 * @param nexts	邻居表		不可变
	 * @param distances	距离表	不可变
	 * @param solution			可变
	 * @param res				可变
	 */
	private static void getShortestPaths(String cur, String end,
			HashMap<String, ArrayList<String>> nexts,
			HashMap<String, Integer> distances, LinkedList<String> solution,
			List<List<String>> res) {
		solution.add(cur); //所有正在走的路径
		if (end.equals(cur)) {  //搜到了，basecase
			res.add(new LinkedList<String>(solution)); //把所有走过的路径加到res中；
		} else {
			for (String next : nexts.get(cur)) { 	//cur拿到所有的邻居，
				if (distances.get(next) == distances.get(cur) + 1) { //只要cur的下一个节点，因为找的是最短路径，
					getShortestPaths(next, end, nexts, distances, solution, res);
				}
			}
		}
		solution.pollLast(); //注意每次要抹掉最后一个，因为solution只是一个实例，递归的过程中防止相互影响；
	}
}
package lintcode.difficulty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _单词搜索2_1 {
	static PreTree root = new PreTree();
	static int[][] step = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };


	public static class PreTree {
		String word;
		PreTree[] next = new PreTree[26];

		public PreTree apendNode(char c) {
			PreTree curNode = next[c - 'a'];
			// 如果当前不存在
			if (curNode == null) {
				next[c - 'a'] = new PreTree();
			}
			return next[c - 'a'];
		}
	}
	
	public static void main(String[] args) {
		String[] boards = new String[] {"ac","cb"};

		List<String> words = Arrays.asList("ab");
		char[][] board = new char[boards.length][boards[0].length()];
		for (int i = 0; i < board.length; i++) {
			board[i] = boards[i].toCharArray();
		}
		List<String> wordSearchII = wordSearchII(board, words);
		System.out.println(wordSearchII);
	}


	public static List<String> wordSearchII(char[][] board, List<String> words) {
		// write your code here
		List<String> result = new ArrayList<>();
		// 构造前缀树
		for (String word : words) {
			PreTree cur = root;
			char[] charArray = word.toCharArray();
			for (char c : charArray) {
				cur = cur.apendNode(c);
			}
			cur.word = word;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				DFS(root, board, i, j, result);
			}
		}
		Collections.sort(result);
		return result;
	}

	private static void DFS(PreTree node, char[][] board, int x, int y, List<String> result) {
		// TODO Auto-generated method stub

		if (x < 0 || y < 0 || x >= board.length || y >= board[x].length || board[x][y] == '0') {
			return;
		}

		// 查看当前
		PreTree curNode = node.next[board[x][y] - 'a'];
		if (curNode != null) {
			if (curNode.word != null) {
				result.add(curNode.word);
				curNode.word = null;
			}
			
			char pre = board[x][y];
			board[x][y] = '0';

			for (int i = 0; i < step.length; i++) {
				DFS(curNode, board, x + step[i][0], y + step[i][1], result);
			}
			board[x][y] = pre;
		}

	}

}

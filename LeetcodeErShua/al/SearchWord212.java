/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SearchWord212 {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word; // 存储完整单词，仅在叶子节点有效
    }

    private TrieNode root = new TrieNode();
    private List<String> result = new ArrayList<>();
    private char[][] board;
    private int rows, cols;
    // 四个方向
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.rows = board.length;
        if (rows == 0) return result;
        this.cols = board[0].length;

        // 构建前缀树
        buildTrie(words);

        // 遍历整个棋盘，开始DFS
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char c = board[i][j];
                if (root.children[c - 'a'] != null) {
                    // 从有对应前缀的位置开始搜索
                    dfs(i, j, root, visited);
                }
            }
        }

        return result;
    }

    // 构建前缀树
    private void buildTrie(String[] words) {
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word; // 在单词结尾存储完整单词
        }
    }

    private void dfs(int row, int col, TrieNode node, boolean[][] visited) {
        // 检查边界
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }

        // 检查是否已访问
        if (visited[row][col]) {
            return;
        }

        char c = board[row][col];
        int index = c - 'a';

        // 如果当前字符不在前缀树中，直接返回
        if (node.children[index] == null) {
            return;
        }

        // 移动到下一个前缀节点
        TrieNode nextNode = node.children[index];

        // 如果找到完整单词，添加到结果集
        if (nextNode.word != null) {
            result.add(nextNode.word);
            nextNode.word = null; // 防止重复添加
        }

        // 标记为已访问
        visited[row][col] = true;

        // 向四个方向搜索
        for (int[] dir : directions) {
            dfs(row + dir[0], col + dir[1], nextNode, visited);
        }

        // 回溯：取消标记
        visited[row][col] = false;
    }


}

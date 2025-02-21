import com.sun.javafx.logging.JFRInputEvent;
import sun.text.normalizer.Trie;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;


public class WordSearchTwo212 {  //这个太慢了难搞  还是前缀树好搞
//    public static void main(String[] args) {
//char[][] array = {{'a'}};
//        String[] words = {"ab"};
//        for (String word : findWords(array, words)) {
//            System.out.println(word);
//        }
//    }
//     private static final int[][] DIRECTIONS = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
//    public  static List<String> findWords(char[][] board, String[] words) {
//        List<String> res = new ArrayList<>();
//        int row=board.length;
//        int col=board[0].length;
//        boolean[][] visited = new boolean[row][col];
//        for(String word : words) {
//            visited=new boolean [board.length][board[0].length];
//            char c=word.charAt(0);
//
//            ArrayDeque<int[]> stack = new ArrayDeque<>();
//            for (int i=0;i<board.length;i++) {
//                for (int j=0;j<board[0].length;j++) {
//                    if(board[i][j]==c){
//                        stack.addFirst(new int[]{i,j});
//                    }
//                }
//            }
//
//
//            if(stack.isEmpty()){ //不存在首字母
//                continue;
//            }
//            boolean flag=false;
//            if (word.length()==1){res.add(word);continue;}
//            while (!stack.isEmpty()) {
//                int[] arr = stack.removeFirst();
//                int rowindex=arr[0];
//                int colindex=arr[1];
//                visited[rowindex][colindex]=true;
//                for (int[] dir : DIRECTIONS) {
//
//            int newX = rowindex + dir[0];
//            int newY = colindex + dir[1];
//            if(newX>=row||newY>=col||newX<0||newY<0||board[newX][newY]!=word.charAt(1))
//            {
//                continue;
//            }
//           flag=flag|| DFS(board,word,visited,1, newX, newY);
//                }
//                visited[rowindex][colindex]=false;
//            }
//
//        if(flag)
//            res.add(word);
//
//
//        }
//
//
//
//
//        return res;
//    }
//
//    public static boolean DFS(char[][] board, String word,boolean[][] visited,int index,int row,int col) {
//        if(index== word.length()){
//             return true;
//         }
//
//
//        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length|| board[row][col] !=word.charAt(index)|| visited[row][col]) {
//            return false;
//        }
//
//         visited[row][col] = true;
//
//         boolean flag=false;
//        for (int[] dir : DIRECTIONS) {
//            int newX = row + dir[0];
//            int newY = col + dir[1];
//           flag=flag|| DFS(board,word,visited,index+1, newX, newY);
//        }
//        visited[row][col]=false;
//        return flag;
//
//
//
//
//    }




class TrieNode {
    TrieNode[] children = new TrieNode[26]; // 使用数组代替 HashMap
    String word = null;
}

public class Solution {
    private final int[][] DIRECTIONS = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {
        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) return;

        node = node.children[c - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null; // 避免重复添加
        }

        board[i][j] = '#'; // 标记为已访问
        for (int[] dir : DIRECTIONS) {
            int newX = i + dir[0];
            int newY = j + dir[1];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                dfs(board, newX, newY, node, res);
            }
        }
        board[i][j] = c; // 恢复原状
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = word;
        }
        return root;
    }
}
}

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

     public WordDictionary() {
        root = new  TrieNode();
    }

    public void addWord(String word) {
          TrieNode cur = root;
    for (char c : word.toCharArray()) {
        // 如果当前字符的子节点不存在，创建新的子节点并赋值给data
        if (!cur.children.containsKey(c)) {
             TrieNode newNode = new  TrieNode();
            newNode.data = c;  // 将当前字符赋值给data
            cur.children.put(c, newNode);
        }
        cur = cur.children.get(c);  // 进入下一个子节点
    }
    cur.isWord = true;  // 设置单词结束标记

    }

public boolean search(String word) {
    ArrayDeque<TrieNode> queue = new ArrayDeque<>();
    queue.add(root);  // 从根节点开始搜索

    for (char c : word.toCharArray()) {
        int size = queue.size();
        ArrayDeque<TrieNode> nextQueue = new ArrayDeque<>(); // 用于存储下一层的搜索节点

        if (c == '.') {
            // 通配符情况：扩展所有可能的子节点
            for (int i = 0; i < size; i++) {
                TrieNode node = queue.poll();
                nextQueue.addAll(node.children.values());
            }
        } else {
            // 普通字符情况：匹配当前字符的子节点
            for (int i = 0; i < size; i++) {
                TrieNode node = queue.poll();
                TrieNode child = node.children.get(c);
                if (child != null) {
                    nextQueue.add(child);
                }
            }
        }

        queue = nextQueue; // 更新队列，进入下一层搜索
        if (queue.isEmpty()) {
            return false; // 如果搜索完某一层没有可选节点，说明匹配失败
        }
    }

    // 最终检查当前层是否存在标记为完整单词的节点
    for (TrieNode node : queue) {
        if (node.isWord) {
            return true;
        }
    }
    return false;
}






    public static class TrieNode
    {
        public Character data;
        boolean isWord;
        Map<Character,  TrieNode> children;

        public TrieNode()
        {
            children = new HashMap<Character,  TrieNode>();
            isWord = false;
        }

    }

    public static TrieNode root;
}

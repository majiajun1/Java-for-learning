import java.util.HashMap;
import java.util.Map;

public class Trie208 {

    public static class TrieNode
    {
        public Character data;
        boolean isWord;
        Map<Character, TrieNode> children;

        public TrieNode()
        {
            children = new HashMap<Character, TrieNode>();
            isWord = false;
        }

    }
    public static TrieNode root;
    public Trie208()
    {
          root = new TrieNode();
    }


    public boolean  search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }

            cur = cur.children.get(c);
        }
        return cur.isWord;
    }

   public static void insert(String word) {
    TrieNode cur = root;
    for (char c : word.toCharArray()) {
        // 如果当前字符的子节点不存在，创建新的子节点并赋值给data
        if (!cur.children.containsKey(c)) {
            TrieNode newNode = new TrieNode();
            newNode.data = c;  // 将当前字符赋值给data
            cur.children.put(c, newNode);
        }
        cur = cur.children.get(c);  // 进入下一个子节点
    }
    cur.isWord = true;  // 设置单词结束标记
}

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return true;
    }

    public static void printTrie(TrieNode node, String prefix) {
        if (node == null) {
            return;
        }

        // 打印当前节点的信息
        System.out.println("Node: " + prefix + ", isWord: " + node.isWord);

        // 遍历当前节点的所有子节点
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            // 递归打印每个子节点，当前前缀加上该字符
            printTrie(entry.getValue(), prefix + entry.getKey());
        }
    }


}

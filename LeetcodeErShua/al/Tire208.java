/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tire208 {

    class Trie {
        // 定义Trie节点结构
        private class TrieNode {
            // 子节点数组，对应26个小写字母
            TrieNode[] children;
            // 标记该节点是否为一个单词的结尾
            boolean isEndOfWord;

            public TrieNode() {
                children = new TrieNode[26];
                isEndOfWord = false;
            }
        }

        // 根节点
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // 插入单词到Trie中
        public void insert(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a'; // 将字符转换为0-25的索引

                // 如果当前字符对应的节点不存在，则创建新节点
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }

                // 移动到下一个节点
                current = current.children[index];
            }
            // 标记单词结束
            current.isEndOfWord = true;
        }

        // 搜索单词是否在Trie中
        public boolean search(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';

                // 如果当前字符对应的节点对应的节点不存在，说明单词不存在
                if (current.children[index] == null) {
                    return false;
                }

                current = current.children[index];
            }
            // 只有当到达单词结尾时，才返回true
            return current.isEndOfWord;
        }

        // 检查Trie中是否有以指定前缀开头的单词
        public boolean startsWith(String prefix) {
            TrieNode current = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                int index = c - 'a';

                // 如果当前字符对应的节点不存在，说明前缀不存在
                if (current.children[index] == null) {
                    return false;
                }

                current = current.children[index];
            }
            // 只要能遍历完前缀，就说明存在以此为前缀的单词
            return true;
        }
    }

}

///*
// * -----------------------------------------------------------------------------
// * © Swisslog AG
// * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
// * The mandatory legal liability remains unaffected.
// * -----------------------------------------------------------------------------
// */
//package al;
//
//import java.util.ArrayDeque;
//
//public class Dict211 {
//    class WordDictionary {
//        private TrieNode root;
//
//        public WordDictionary() {
//            root = new TrieNode();
//        }
//
//        public void addWord(String word) {
//            TrieNode cur = root;
//            for (char c : word.toCharArray()) {
//                int index = c - 'a';
//                if (cur.children[index] == null) {
//                    cur.children[index] = new TrieNode();
//                    cur.children[index].data = c;
//                }
//                cur = cur.children[index];
//            }
//            cur.isWord = true;
//        }
//
//        public boolean search(String word) {
//            ArrayDeque<TrieNode> queue = new ArrayDeque<>();
//            queue.add(root);
//
//            for (char c : word.toCharArray()) {
//                int size = queue.size();
//                ArrayDeque<TrieNode> nextQueue = new ArrayDeque<>();
//
//                if (c == '.') {
//                    for (int i = 0; i < size; i++) {
//                        TrieNode node = queue.poll();
//                        for (TrieNode child : node.children) {
//                            if (child != null) {
//                                nextQueue.add(child);
//                            }
//                        }
//                    }
//                } else {
//                    int index = c - 'a';
//                    for (int i = 0; i < size; i++) {
//                        TrieNode node = queue.poll();
//                        if (node.children[index] != null) {
//                            nextQueue.add(node.children[index]);
//                        }
//                    }
//                }
//
//                queue = nextQueue;
//                if (queue.isEmpty()) {
//                    return false;
//                }
//            }
//
//            for (TrieNode node : queue) {
//                if (node.isWord) {
//                    return true;
//                }
//            }
//            return false;
//        }
//
////        private static class TrieNode {
////            char data;
////            boolean isWord;
////            TrieNode[] children = new TrieNode[26]; // 用数组代替HashMap
////        }
//    }
//
//}

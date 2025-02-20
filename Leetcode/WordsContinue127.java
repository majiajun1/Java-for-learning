import java.util.*;

public class WordsContinue127 {
    public static void main(String[] args) {
        System.out.println(ladderLength("hit", "cog", new ArrayList<>(Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"}))));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) {
                    return count;
                }

                char[] wordChars = currentWord.toCharArray();
                for (int j = 0; j < wordChars.length; j++) {
                    char originalChar = wordChars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) {
                            continue;
                        }
                        wordChars[j] = c;
                        String newWord = new String(wordChars);
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord); // 避免重复访问
                        }
                    }
                    wordChars[j] = originalChar; // 恢复原字符
                }
            }
            count++;
        }

        return 0;
    }


//
//    public static boolean getHammingDistance(String str1, String str2) {
//        if (str1.length() != str2.length()) {
//            throw new IllegalArgumentException("Strings must be of equal length");
//        }
//        int distance = 0;
//        for (int i = 0; i < str1.length(); i++) {
//            if (str1.charAt(i) != str2.charAt(i)) {
//                distance++;
//            }
//            if (distance > 1) {
//                return false;
//            }
//        }
//        return distance==1;
//    }
}

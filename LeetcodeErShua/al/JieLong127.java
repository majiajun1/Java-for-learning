/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;

public class JieLong127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        ArrayDeque<String> stack = new ArrayDeque<String>();
        boolean[] visited = new boolean[wordList.size()];
        int count = 1;
        int endWordLocate=-1;
        HashSet<String> startPoint = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            if(hasOneLetterDifference(word, beginWord))
            {
                startPoint.add(word);
                if(endWord.equals(word))
                {
                    return 2;
                }
            }
            if(endWord.equals(word))
            {
                endWordLocate = i;

            }
        }

        if(endWordLocate == -1)
        {
            return 0;
        }
        stack.addLast(endWord);
        visited[endWordLocate] = true;

        while (!stack.isEmpty()) {
            count++;
            int curSize = stack.size();
            for (int i = 0; i < curSize; i++) {
                String cur = stack.pollFirst();
                for(int j = 0; j < wordList.size(); j++)
                {
                    String temp = wordList.get(j) ;
                    if(hasOneLetterDifference(cur, temp)&&!visited[j])
                    {
                        if(startPoint.contains(temp))
                        {
                            return ++count;
                        }
                        stack.addLast(temp);
                        visited[j] = true;
                    }

                }
            }

        }
        return 0;
    }

    public static boolean hasOneLetterDifference(String s1, String s2) {
        // 长度不同直接返回false
        if (s1.length() != s2.length()) {
            return false;
        }

        int diffCount = 0;
        // 遍历每个字符，统计不同的数量
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
                // 若差距超过1，提前返回false
                if (diffCount > 1) {
                    return false;
                }
            }
        }
        // 只有恰好1个不同才返回true
        return diffCount == 1;
    }
}

/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayDeque;

public class MinGene433 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        ArrayDeque<String> stack = new ArrayDeque<String>();
        boolean[] visited = new boolean[bank.length];
        int count = 1;
        stack.push(startGene);
        while (!stack.isEmpty()) {
            int curSize = stack.size();
            for (int i = 0; i < curSize; i++) {
                String cur = stack.pop();
                for(int j = 0; j < bank.length; j++)
                {
                    String temp = bank[j];
                    if(hasOneLetterDifference(cur, temp)&&!visited[j])
                    {
                        if(temp.equals(endGene))
                        {
                            return count;
                        }
                        stack.addLast(temp);
                        visited[j] = true;
                    }

                }
            }
            count++;
        }
        return -1;
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

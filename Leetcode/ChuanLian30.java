import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChuanLian30 {
    public static void main(String[] args) {
        String s="wordgoodgoodgoodbestword";
        String[] words={"word","good","best","good"};


        List<Integer> ans=findSubstring(s,words);
        System.out.println(ans);

    }

public static  List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;

        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;

        // 构建单词计数表
        Map<String,Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // 遍历每个偏移量
        for (int i = 0; i < wordLength; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> currentCount = new HashMap<>();

            while (right + wordLength <= s.length()) {
                // 获取当前窗口的单词
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                // 如果是目标单词
                if (wordCount.containsKey(word)) {
                    currentCount.put(word, currentCount.getOrDefault(word, 0) + 1);
                    count++;

                    // 如果某单词次数超出限制，移动左窗口
                    while (currentCount.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        currentCount.put(leftWord, currentCount.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }

                    // 如果窗口大小匹配，记录结果
                    if (count == words.length) {
                        result.add(left);
                    }
                } else {
                    // 非目标单词，重置窗口
                    currentCount.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return result;
    }

}


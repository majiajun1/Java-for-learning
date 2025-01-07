import java.util.ArrayList;
import java.util.List;

public class ZuoYouDuiQi68 {
    public static void main(String[] args) {
        String[] words={"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth=20;
        List<String> ans=fullJustify(words,maxWidth);
        System.out.println(ans);
    }

     public static List<String> fullJustify(String[] words, int maxWidth) {
        int index1 = 0; // 当前行的起始单词索引
        int index2 = 0; // 当前行的结束单词索引
        List<String> ans = new ArrayList<>();
        int[] counts = new int[words.length]; // 每个单词的长度
        for (int i = 0; i < words.length; i++) {
            counts[i] = words[i].length();
        }

        int tempcount = 0; // 当前行的长度计数
        while (index2 < words.length) {
            System.out.println("cur:"+words[index2]);
            tempcount += counts[index2] + 1;
            if(tempcount-1==maxWidth)
            {
                ans.add(JiaRun(words, counts, maxWidth, index1, index2 ));
                tempcount = 0; // 重置计数器
                index1 =index2+1;
                index2=index1;
                continue;

            }// 加上当前单词长度和一个空格

            if (tempcount >maxWidth) {
                tempcount -= counts[index2] + 1; // 回退多加的单词和空格长度
                ans.add(JiaRun(words, counts, maxWidth, index1, index2 - 1));
                tempcount = 0; // 重置计数器
                index1 = index2; // 更新起始索引
            } else {
                index2++;
            }
        }

        // 处理最后一行
        if (index1 < words.length) {
            ans.add(JiaRun(words, counts, maxWidth, index1, index2 - 1));
        }

        return ans;
    }

    public static String JiaRun(String[] words, int[] counts, int maxWidth, int index1, int index2) {
    StringBuilder result = new StringBuilder();

    int wordCount = index2 - index1 + 1; // 当前行单词数量
    int totalWordLength = 0;

    // 计算单词总长度
    for (int i = index1; i <= index2; i++) {
        totalWordLength += counts[i];
    }

    int totalSpaces = maxWidth - totalWordLength; // 总空格数

    // 情况 1：只有一个单词，左对齐，右侧补齐空格
    if (wordCount == 1) {
        result.append(words[index1]);
        for (int i = 0; i < totalSpaces; i++) {
            result.append(" ");
        }
        return result.toString();
    }

    // 情况 2：最后一行，左对齐，单词之间一个空格，右侧补齐空格
    if (index2 == words.length - 1) {
        for (int i = index1; i <= index2; i++) {
            result.append(words[i]);
            if (i != index2) {
                result.append(" ");
            }
        }
        // 补齐右侧空格
        while (result.length() < maxWidth) {
            result.append(" ");
        }
        return result.toString();
    }

    // 情况 3：普通行，两端对齐，分配空格
    int minSpaces = totalSpaces / (wordCount - 1); // 每个间隙的最小空格数
    int extraSpaces = totalSpaces % (wordCount - 1); // 剩余的额外空格数

    for (int i = index1; i < index2; i++) {
        result.append(words[i]);
        // 添加基本空格
        for (int j = 0; j < minSpaces; j++) {
            result.append(" ");
        }
        // 分配额外空格
        if (extraSpaces > 0) {
            result.append(" ");
            extraSpaces--;
        }
    }

    // 添加最后一个单词
    result.append(words[index2]);

    return result.toString();
    }






}


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Line17 {


    public static void main(String[] args) {
        String str = "23";
        List<String> list = letterCombinations(str);
        System.out.println(list);

    }




    //比如digits如果为"23",num 为0，则str表示2对应的 abc
    public static List<String> letterCombinations(String digits) {
        // 存储数字 2-9 对应的字母，索引 0 和 1 为空
        String[] phoneMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> combinations = new ArrayList<>();

        // 输入为空时直接返回空结果
        if (digits == null || digits.length() == 0) {
            return combinations;
        }

        // 开始回溯
        backtrack(combinations, phoneMap, digits, 0, new StringBuilder());
        return combinations;
    }

    // 回溯方法
    private static void backtrack(List<String> combinations, String[] phoneMap,
                                  String digits, int index, StringBuilder current) {
        // 终止条件：已经处理完所有数字
        if (index == digits.length()) {
            combinations.add(current.toString());
            return;
        }

        // 获取当前数字对应的字母字符串
        int digit = digits.charAt(index) - '0'; // 将字符 '2'-'9' 转换为整数 2-9
        String letters = phoneMap[digit];

        // 遍历当前数字的每个字母
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i)); // 添加当前字母
            backtrack(combinations, phoneMap, digits, index + 1, current); // 处理下一个数字
            current.deleteCharAt(current.length() - 1); // 回溯，撤销选择
        }
    }
}

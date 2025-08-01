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

public class Tele17 {
    private static final String[] LETTER_MAPPINGS = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    private List<String> result = new ArrayList<>();
    private StringBuilder current = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(digits, 0);
        return result;
    }

    // 回溯方法
    // index: 当前处理的数字索引
    private void backtrack(String digits, int index) {
        // 终止条件：如果已经处理完所有数字，将当前组合加入结果集
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // 获取当前数字对应的字母
        char digit = digits.charAt(index);
        String letters = LETTER_MAPPINGS[digit - '0'];

        // 遍历所有可能的字母
        for (int i = 0; i < letters.length(); i++) {
            // 选择当前字母
            current.append(letters.charAt(i));

            // 递归处理下一个数字
            backtrack(digits, index + 1);

            // 回溯：移除最后一个字母，尝试其他可能性
            current.deleteCharAt(current.length() - 1);
        }
    }

}


import java.util.*;
import java.util.spi.AbstractResourceBundleProvider;


public class Fifth_LongestSubString {
    public static void main(String[] args) {
        String s = "bb";
        System.out.println(longestPalindrome(s));  // 输出 "bab" 或 "aba"
    }

    public static boolean ishuiwen(int i, int j, String str) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }


        int maxlen = 1;
        int begin = 0;
        String longest = s.substring(0, 1);
        // 第一层循环，遍历每个字符作为起点
        for (int i = 0; i < s.length() - 1; i++) {

            // 第二层循环，从字符串末尾向前遍历，直到 j 达到 i
            for (int j = i + 1; j < s.length(); j++) {
                if (j - i + 1 > maxlen && ishuiwen(i, j, s)) {//若当前长度比已有的长并且满足回文
                    maxlen = j - i + 1;
                    begin = i;//起点才能找到字串
                }


            }


            // 将构建的回文子串添加到列表中


        }
        return s.substring(begin, begin + maxlen);
    }
}
public class ErShuaLongHuiWen5 {
public static String longestPalindrome(String s) {
        int n = s.length();  //这题用DP就意义不大啊
        if (n <= 1) return s; // 特殊情况处理

        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;
        int start = 0;

        // **单个字符的回文**
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // **填充 DP 表**
        for (int i = n - 1; i >= 0; i--) {  // **从后往前遍历 i**
            for (int j = i + 1; j < n; j++) {  // **从前往后遍历 j**
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) { // **两个相邻字符**
                        dp[i][j] = true;
                    } else { // **长度大于 2，依赖 dp[i+1][j-1]**
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }






}

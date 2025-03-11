public class JiaoCuoString97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int n2 = s2.length();
        boolean[][] dp = new boolean[n+1][n2+1];
        if(s1.length() + s2.length()     !=s3.length())
        {
            return false;
        }
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if(dp[i-1][0]&&s1.charAt(i-1)==s3.charAt(i-1))
            {
                dp[i][0] = true;
            }
        }
        for (int j = 1; j <= n2; j++) {
            if(dp[0][j-1]&&s2.charAt(j-1)==s3.charAt(j-1))  //跟之前想法一样 初始化的话 相当于两个字符串遍历一次 看看能不能成为字符串的前部分
            {
                dp[0][j] = true;
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n2; j++) {  //状态传导：要不是选用s1的一个字母 要不是选用s2的一个字符  如果能形成字符串则为1（有路径）
                //上和左代表着选用哪个字符  往右选用s1  往下选用s2
                dp[i][j]=(dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1))||(dp[i ][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1));
            }
        }


        return dp[n][n2];
    }
}

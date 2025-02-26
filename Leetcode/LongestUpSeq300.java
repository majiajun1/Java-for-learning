import java.util.Arrays;

public class LongestUpSeq300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);


        int maxLength = 1; // 记录最大长度


        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { // 递增关系
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]); // 维护最大 LIS
        }


    return maxLength;
    }
}

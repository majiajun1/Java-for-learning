/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package com;

public class JumpGame55 {
    public static void main(String[] args) {
        int[] ums = {2,3,1,1,4};
        canJump(ums);
    }
    public static boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if(dp[i])
            {
                if(i+nums[i]>=nums.length)
                {
                    return true;
                }
                for(int j=0;j<=nums[i];j++)
                {
                    dp[i+j] = true;

                }
            }
        }
        return dp[nums.length-1];
    }
}

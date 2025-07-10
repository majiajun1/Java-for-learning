/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.Arrays;

public class Smallest209 {
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,arr));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int windowLeft = 0, windowRight = 0;
        if(nums.length == 1)
        {
            if(nums[0] >= target)
            {
                return 1;
            }else
            {
                return 0;
            }
        }

        int curSum = 0;
        int count = Integer.MAX_VALUE;

        while(  windowRight < nums.length )
        {
             curSum += nums[windowRight++];
             while (curSum >= target)
             {
                 count=Math.min(count, windowRight - windowLeft);
                 curSum -= nums[windowLeft++];
             }
        }
        return count==Integer.MAX_VALUE?0:count;

    }
}

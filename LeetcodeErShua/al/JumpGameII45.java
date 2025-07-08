/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayDeque;

public class JumpGameII45 {
    public static void main(String[] args) {

    }
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;

        int jumps = 0;
        int currentMax = 0;
        int nextMax = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > currentMax) {
                jumps++;
                currentMax = nextMax;
                if (currentMax >= nums.length - 1) {
                    return jumps;
                }
            }
            nextMax = Math.max(nextMax, i + nums[i]);
        }
        return jumps;
    }


}

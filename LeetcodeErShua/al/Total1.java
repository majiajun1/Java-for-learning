/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.HashMap;

public class Total1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length ; i++) {
            int curr = nums[i];
            int last=target-curr;
            if(map.containsKey(last)){
                return new int[]{map.get(last),i};
            }
            map.put(curr, i);
        }

        return null;
    }
}

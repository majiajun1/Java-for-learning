/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.Arrays;
import java.util.HashMap;

public class ChongFu219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (map.containsKey(cur)) {
                int lastIndex = map.get(cur);
                if(Math.abs(i - lastIndex) <= k)
                {
                    return true;
                }else
                {
                    map.put(cur, i );
                }
            }else
            {
                map.put(cur, i);
            }
        }
        return false;
    }
}

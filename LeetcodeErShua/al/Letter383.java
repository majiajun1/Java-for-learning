/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Letter383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (Character c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Character c : ransomNote.toCharArray()) {
            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    map.put(c, map.get(c) - 1);
                } else if (map.get(c) == 0) {
                    return false;
                }
            }else
            {
                return false;
            }

       }
        return true;
    }
}

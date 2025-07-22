/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.HashMap;

public class SmallSeq76 {
    public static void main(String[] args) {

    }

    public String minWindow(String s, String t) {
        int left = 0, right = 0, min = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> curWindow = new HashMap<>();
        String res = new String(s);
        while(right < s.length()) {
            Character c = s.charAt(right);


            right++;

        }
        return null;
    }
}

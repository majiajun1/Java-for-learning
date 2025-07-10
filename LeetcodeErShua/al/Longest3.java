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

public class Longest3 {
    public static void main(String[] args) {
        String s="pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int maxCount=1;
        HashMap<Character, Integer> map = new HashMap<>();
        int left=0;
        int right=0;
        while(right<s.length()){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            while (map.containsKey(s.charAt(right))&&map.get(s.charAt(right))>1){
                    if(map.get(s.charAt(left))==1){
                        map.remove(s.charAt(left));
                        left++;
                        continue;
                    }

                    map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)-1);
                    left++;

            }
            maxCount=Math.max(maxCount,map.size());
            right++;

        }
        return maxCount;
    }
}

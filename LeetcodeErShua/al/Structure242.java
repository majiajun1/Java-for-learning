/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.HashMap;

public class Structure242 {
    public boolean isAnagram(String s, String t) {

        HashMap<Character,Integer> map = new HashMap<>();

        if(s.length() != t.length()) return false;

        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);

        }
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(!map.containsKey(c))  {
                return false;
            }else
            {
                if(map.get(c) > 0)
                    map.put(c,map.get(c) - 1);
                else
                {
                    return false;
                }
            }
        }
        return true;
    }
}

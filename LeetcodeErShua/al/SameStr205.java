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

public class SameStr205 {
    public static void main(String[] args) {
        String s1 = "badc";
    }
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        HashMap<Character,Character> map2= new HashMap<>();
        if(s.length() != t.length()) return false;
        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))&&!map2.containsKey(t.charAt(i)))
            {
                map.put(s.charAt(i), t.charAt(i));
                map2.put(t.charAt(i), s.charAt(i));
            }else if(map.containsKey(s.charAt(i))){
                 if(map.get(s.charAt(i)) != t.charAt(i))
                     return false;
            }else if(map2.containsKey(t.charAt(i))){
                 if(map2.get(t.charAt(i)) != s.charAt(i))
                     return false;
            }
        }
         return true;
    }
}

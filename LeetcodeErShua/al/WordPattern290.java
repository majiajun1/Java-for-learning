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

public class WordPattern290 {
    public static void main(String[] args) {
        String pattern = "abc";
        String s="dog cat dog";
        wordPattern(pattern,s);
    }
    public static  boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        HashMap<Character,String> map = new HashMap<>();
        HashMap<String,Character> map2 = new HashMap<>();
        if(pattern.length() != words.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String cur = words[i];
            if(!map.containsKey(c)&&!map2.containsKey(cur))
            {
                map.put(c,cur);
                map2.put(cur,c);
                continue;
            }


            if(map2.containsKey(cur))
            {
                 if(c!=map2.get(cur))
                 {
                     return false;
                 }
            }

            if(map.containsKey(c))
            {
                if(!cur.equals(map.get(c)))
                    return false;
            }


        }
        return true;
    }
}

/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Group49 {
   public static void main(String[] args) {
        String[] str={"eat", "tea", "tan", "ate", "nat", "bat"};

    }
    static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String curStr : strs)
        {
            char[] chArr = curStr.toCharArray();
            Arrays.sort(chArr);
            String curStrHash = new String(chArr);
            if(map.containsKey(curStrHash))
            {
                map.get(curStrHash).add(curStr);
            }else
            {
                List<String> list = new ArrayList<>();
                list.add(curStr);
                map.put(curStrHash,list);
            }

        }
        result=new ArrayList<>(map.values());
        return result;
    }
}

/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package com;

import java.util.Arrays;
import java.util.Comparator;

public class LongestPublic14 {
    public static void main(String[] args) {
        String[] str = {"a","b"};
        System.out.printf(longestCommonPrefix(str));
    }
    public static String longestCommonPrefix(String[] strs)
    {
        if (strs == null || strs.length == 0||strs[0].length()==0) return "";
        if(strs.length == 1) return strs[0];
        StringBuilder sb = new StringBuilder();
        int prefix=0;
        Arrays.sort(strs, (s1, s2) -> s1.length() - s2.length());


        while (prefix<strs[0].length())
        {
            sb.append(strs[0].charAt(prefix));
            for(String s : strs)
            {
                if(s.charAt(prefix)==sb.charAt(prefix))
                {
                    continue;
                }else
                {
                    return sb.substring(0, prefix).toString();
                }
            }
            prefix++;

        }

        return sb.toString();
    }
}

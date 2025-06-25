/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package com;

import org.apache.commons.dbcp.DelegatingStatement;

import java.util.HashMap;

public class RomanToInt13 {
    public static void main(String[] args) {
        String str = "III";
        RomanToInt13 r = new RomanToInt13();
        System.out.println(r.romanToInt("III"));
    }

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;
        int i = 0;
        while (i < s.length()) {
            char current = s.charAt(i);
            int currentVal = map.get(current);

            // 检查是否有下一个字符，并判断是否是减法组合
            if (i + 1 < s.length()) {
                char next = s.charAt(i + 1);
                int nextVal = map.get(next);

                if (currentVal < nextVal) {
                    total += (nextVal - currentVal);
                    i += 2; // 跳过下一个字符
                    continue;
                }
            }

            // 普通情况，直接加当前值
            total += currentVal;
            i++;
        }
        return total;
    }
}

/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package com;

import java.util.stream.Stream;

public class ZTran6 {
    public static void main(String[] args) {
        String s="PAYPALISHIRING";
        int nunRows=4;
        System.out.println(convert(s, nunRows));
    }
        public static String convert(String s, int numRows) {
        if(numRows==1) return s;
            StringBuilder[] sbs = Stream.generate(StringBuilder::new)
                    .limit(numRows)
                    .toArray(StringBuilder[]::new);
            int xindex=0;
            int index=0;

            while (index < s.length()) {
                while (index < s.length()&&xindex < numRows) {
                    sbs[xindex++].append(s.charAt(index++));
                }
                xindex=numRows-2;
                    while (index < s.length()&&xindex>=0)
                    {
                        sbs[xindex--].append(s.charAt(index++));
                    }

                xindex=1;

            }
            StringBuilder res = new StringBuilder();
            for (StringBuilder sb : sbs) {
                res.append(sb);
            }
            return res.toString();
        }
}

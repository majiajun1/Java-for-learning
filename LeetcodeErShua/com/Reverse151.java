/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package com;

public class Reverse151 {
    public static void main(String[] args) {
        String str = "  hello world  ";
        reverseWords(str);
    }
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if(words[i].length() > 0){
                sb.append(words[i]);
                sb.append(" ");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}

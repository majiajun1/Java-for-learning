/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

public class SubSeq392 {
    public boolean isSubsequence(String s, String t) {
        int index1=0;
        int index2=0;
        while(index1<s.length() && index2<t.length()){
            if(s.charAt(index1)==t.charAt(index2)){
                index1++;
                index2++;
            }else
            {
                index2++;
            }
        }
        if(index1==s.length())
        {
            return true;
        }else
            return false;
    }
}

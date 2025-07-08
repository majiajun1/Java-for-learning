/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

public class LastLength58 {
    public static void main(String[] args)
    {

    }
    public int lengthOfLastWord(String s)
    {
        int index=s.length()-1;
        int last=s.length()-1;
        while(s.charAt(last)==' ')
        {
            last--;
        }
        index=last;

        while (index>=0 && s.charAt(index)!=' ')
        {
            index--;
        }
        return last-index ;

    }
    }

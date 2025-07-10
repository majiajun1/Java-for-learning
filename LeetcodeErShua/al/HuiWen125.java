/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

public class HuiWen125 {
    public static void main(String[] args) {
        String s="aa";
        System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s) {
        if(s.length()==1){
            return true;
        }
        s= s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int mid=s.length()/2;
        if(s.length()==0){
            return true;
        }
        String s1,s2=s;
        if(s.length()%2!=0){
              s1=s.substring(mid+1);
                s2=new StringBuilder(s.substring(0, mid)).reverse().toString();
        }else
        {
              s1=s.substring(mid);
               s2=new StringBuilder(s.substring(0, mid)).reverse().toString();
        }

        if (s1.equals(s2))
        {
            return true;
        }else
        {
            return false;
        }

    }
}

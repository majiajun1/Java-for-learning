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

public class HappyNum202 {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
    public static boolean isHappy(int n) {

        HashSet<Integer> set=new HashSet<>();
        while (n != 1) {
            int sum = 0;
            while (n !=0)
            {
                int temp = n%10;
                n = n/10;
                sum = (sum + temp*temp);
            }

            if(set.contains(sum))
            {
                return false;
            }else{
                set.add(sum);
            }
            n=sum;
        }

        return true;
    }
}

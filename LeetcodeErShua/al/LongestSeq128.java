/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.lang.module.FindException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LongestSeq128 {
    public static void main(String[] args) {
        int[] arr= {100,4,200,1,3,2};
        longestConsecutive(arr);
    }
    public static int longestConsecutive(int[] nums) {

      HashSet<Integer> set = new HashSet<>();
      int biggest = 0;
      for(int i = 0; i < nums.length; i++) {
          set.add(nums[i]);
      }
      for(int i = 0; i < nums.length; i++) {
          //go left and go right
        int founded = foundTheSeq(nums[i],set);
        if(founded > biggest) {
           biggest = founded;
          }
      }
        return biggest;
    }

    public static int foundTheSeq(int cur,HashSet<Integer> set) {
        int seq=1;
        //go left
        int left = cur-1;
        while (set.contains(left)) {
                seq++;
                set.remove(left);
                left--;
        }

        int right = cur+1;
        while (set.contains(right)) {
                 seq++;
                 set.remove(right);
                 right++;
         }

       return seq;
    }
}
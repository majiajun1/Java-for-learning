/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayList;
import java.util.List;

public class Range228 {
    public static void main(String[] args) {
        int[] arr={-1};
        for(String a : summaryRanges(arr))
        {
            System.out.println(a);
        }
    }
    public static List<String> summaryRanges(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        List<String> list = new ArrayList<String>();
        res.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
             int cur = nums[i];
             if (cur == nums[i - 1]+1) {
                   res.add(cur);
             }else
             {
                 if(res.size()==1)
                 {
                     list.add(new String(Integer.toString(res.get(0))));

                     res.clear();
                 }else
                 {
                     String temp=Integer.toString(res.get(0) )+"->"+Integer.toString(res.get(res.size()-1));
                     list.add(new String(temp));
                     res.clear();
                 }
                 res.add(cur);
             }
        }
        if(res.size()>0) {
            if(res.size()==1)
            {
                list.add(new String(Integer.toString(res.get(0))));

            }else
            {
                String temp=Integer.toString(res.get(0) )+"->"+Integer.toString(res.get(res.size()-1));
                list.add(new String(temp));

            }
        }

        return list;
    }
}

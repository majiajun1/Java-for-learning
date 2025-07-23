/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HeBing56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];
        if (intervals.length == 1) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List<int[]> res = new ArrayList<>();

        int right=1;
        res.add(intervals[0]);
        while(right<intervals.length){
            int[] leftRange = res.get(res.size()-1);
            int[] rightRange= intervals[right];
            if(leftRange[1]>=rightRange[0]){
                int rightmax=Math.max(leftRange[1],rightRange[1]);
                int leftmin=Math.min(leftRange[0],rightRange[0]);
                res.remove(res.size()-1);
                res.add(new int[]{leftmin,rightmax});

            }else
            {
                res.add(rightRange);

            }
            right++;

        }
        return res.toArray(new int[res.size()][]);
    }
}

/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import com.sun.source.tree.NewArrayTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Insert57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) return new int[][]{newInterval};
        List<int[]> res = new ArrayList<>();


        res.addAll(Arrays.asList(intervals));
        res.add(newInterval);
        res.sort(Comparator.comparingInt(a -> a[0]));
        List<int[]> res2 = new ArrayList<>();




        int right=1;
        res2.add(res.get(0));

        while(right<res.size()){
            int[] leftRange = res2.get(res2.size()-1);
            int[] rightRange= res.get(right);

            if(leftRange[1]>=rightRange[0]&&!(rightRange[1]<leftRange[0]) ){
                int rightmax=Math.max(leftRange[1],rightRange[1]);
                int leftmin=Math.min(leftRange[0],rightRange[0]);
                res2.remove(res2.size()-1);
                res2.add(new int[]{leftmin,rightmax});

            }else
            {
                res2.add(rightRange);

            }
            right++;

        }
        return res2.toArray(new int[res2.size()][]);
    }
}

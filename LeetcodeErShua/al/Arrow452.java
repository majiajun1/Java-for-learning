/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.Arrays;
import java.util.Comparator;

public class Arrow452 {
    public static void main(String[] args) {
        int[][] intervals = {
                {-2147483646,-2147483645},
                {2147483646,2147483647}
        };
        System.out.println(findMinArrowShots(intervals));;
    }
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int maxArrowShots = points.length;
        if(maxArrowShots < 2) return maxArrowShots;
        for (int i = 1; i < points.length; i++) {
            long leftleft=points[i-1][0];
            long leftright=points[i-1][1];
            long rightright=points[i][1];
            long rightleft=points[i][0];

            if(leftright>=rightleft)
            {
                if(leftright<=rightright){
                points[i][1]= Math.toIntExact(Math.min(leftright, rightright));
                }else {
                    points[i-1][1]= Math.toIntExact(Math.max(leftright, rightright));
                }

                maxArrowShots--;
            }

        }
        return maxArrowShots;
    }
}

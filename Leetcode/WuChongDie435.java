import java.util.Arrays;

public class WuChongDie435 {
    public static void main(String[] args) {
        int[][] arr = {{1,100},{11,22},{1,11},{2,12}};
        System.out.println(eraseOverlapIntervals(arr));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        int ans=0;
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        if(intervals==null || intervals.length==0) return 0;
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end= intervals[i][1];
            int lastend=intervals[i-1][1];
            if(start>=lastend)
            {
                continue;
            }
            else
            {
                ans++;
                intervals[i][1]=Math.min(lastend,end);
            }

        }
        return ans;
    }
}

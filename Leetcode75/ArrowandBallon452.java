import java.util.Arrays;

public class ArrowandBallon452 {
    public static void main(String[] args) {
        int[][] points={{-2147483646,-2147483645},{2147483646,2147483647}};

        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
         int ans=points.length;
         Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
         if(points==null || points.length==0) return 0;
         for (int i = 1; i < points.length; i++) {
             int start = points[i][0];
             int end= points[i][1];
             int lastend=points[i-1][1];

             if(start<=lastend)
             {
                ans--;
                points[i][1]=  Math.min(end,lastend);

             }


        }

        return ans;
    }
}

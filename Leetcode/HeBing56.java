import java.util.*;

public class HeBing56 {
    public static void main(String[] args) {
        int[][] nums={{1, 3}, {2, 6},{8,10},{15,18}};
        int[][] ans=merge(nums);
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[i].length;j++){
                System.out.print(ans[i][j]+" ");
            }
        }
    }

    public static int[][] merge(int[][] intervals) {
        ArrayDeque<int[]> list=new ArrayDeque<>();
        if( intervals.length==1||intervals.length==0){
            return intervals;
        }
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        int index=1;
        list.add(new int[]{intervals[0][0],intervals[0][1]});
        while(index<=intervals.length-1)
        {

            int left=intervals[index][0];
            int right=intervals[index][1];
            int[] temp=list.peekLast();
            int curleft=temp[0];
            int curright=temp[1];
            if(left<=curright)
            {
                list.pollLast();
                list.addLast(new int[]{curleft,Math.max(curright,right)});
            }
            else {


                list.addLast(new int[]{left,right});
            }
            index++;
        }
        return list.toArray(new int[list.size()][]);
    }
}

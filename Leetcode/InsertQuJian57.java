import java.util.*;

public class InsertQuJian57 {
    public static void main(String[] args) {
        int[][] arr = {{3,5},{12,15}};
        int[] newarr={6,6};
        int[][] ans=insert(arr,newarr);
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[i].length;j++){
                System.out.print(ans[i][j]+" ");
            }
        }

    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayDeque<int[]> list=new ArrayDeque<>();
        if(intervals.length==0){
            return new int[][]{newInterval};
        }
        if(intervals.length==1){
            if(newInterval[0]<=intervals[0][1]&&newInterval[1]>=intervals[0][0]){
                return new int[][]{{Math.min(intervals[0][0],newInterval[0]),Math.max(intervals[0][1],newInterval[1])}};
            }else if(newInterval[1]<intervals[0][0])
            {
                return new int[][]{newInterval,intervals[0]};
            }
            else {
                return new int[][]{intervals[0],newInterval};
            }
        }

        int index=1;
        list.add(new int[]{intervals[0][0],intervals[0][1]});
        int flag=0;
        while(index<intervals.length){
            int[] temp=list.peekLast();
            int left=temp[0];
            int right=temp[1];
            if(newInterval[0]<=right&&flag==0){
                if(newInterval[1]>=left){
                list.pollLast();
                list.addLast(new int[]{Math.min(newInterval[0],left),Math.max(newInterval[1],right)});
                temp=list.peekLast();
                left=temp[0];
                right=temp[1];}
                else {
                    list.pollLast();
                    list.addLast(newInterval);
                    list.addLast(temp);
                }
                flag=1;
            }

            int curleft=intervals[index][0];
            int curright=intervals[index][1];
            if(curleft<=right)
            {
                list.pollLast();
                list.addLast(new int[]{Math.min(left,curleft),Math.max(curright,right)});
            }
            else {


                list.addLast(new int[]{curleft,curright});
            }
            index++;
        }
        if(flag==0)
        {
            int[] temp=list.peekLast();
            int left=temp[0];
            int right=temp[1];
            if(newInterval[0]<=right&&newInterval[1]>=left){
                list.pollLast();
                list.addLast(new int[]{Math.min(newInterval[0],left),Math.max(newInterval[1],right)});
           }
            else if(newInterval[1]<left){
                 list.pollLast();
                 list.addLast(newInterval);
                 list.addLast(temp);
            }
            else {
                list.addLast(newInterval);
            }
        }

        return list.toArray(new int[list.size()][]);
    }

}





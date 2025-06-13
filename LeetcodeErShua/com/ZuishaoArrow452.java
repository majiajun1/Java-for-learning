package com;

import java.util.Arrays;

public class ZuishaoArrow452 {
    public static void main(String[] args) {
        int[][] points={{1,2},{3,4},{5,6},{7,8}};
        System.out.println(findMinArrowShots(points));
    }
    public static int findMinArrowShots(int[][] points) {
     Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
     int length=points.length;
     int index=1;
     int count=1;
     while(index<=length-1){
         int NowLeft=points[index][0];
         int NowRight=points[index][1];
         int BeforeLeft=points[index-1][0];
         int BeforeRight=points[index-1][1];

         if(NowLeft<BeforeRight&&NowRight>BeforeLeft){  //有交集
             points[index][0]=Math.max(NowLeft,BeforeLeft);
             points[index][1]=Math.min(NowRight,BeforeRight);

         }else
             count++;

         index++;
     }

        return count;
    }
}

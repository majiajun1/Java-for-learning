package TengXun2020Houtai;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.PriorityQueue;

public class GuangJie2 {
    public static void main(String[] args) {

        int[] arr={5,3,8,3,2,5};
        for(int i:findBuilding(arr))
        {
            System.out.println(i);
        }
    }
    public static int[] findBuilding (int[] heights) {
        // write code here
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] res = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
                int High=heights[i];
                int sum=0;
                int left=i-1;
                int right=i+1;
 
        }
    return res;
    }
}

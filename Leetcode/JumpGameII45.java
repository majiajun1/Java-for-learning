

import java.util.ArrayDeque;
import java.util.Deque;

public class JumpGameII45 {
    public static void main(String[] args) {
        int[] nums={2,3,1,1,4};
        System.out.println(jump(nums));
    }


    public static int jump(int[] nums) { //贪心!
        if(nums.length==0||nums.length==1) return 0;
        int maxpose=0;
        int end=0;
        int ans=0;
        for(int i=0;i<nums.length-1;i++){
            maxpose=Math.max(i+nums[i],maxpose);
            if(i==end) {
                end = maxpose;
                ans++;
            }
        }
        return ans;
    }
}

import java.util.Arrays;

public class Rob198 {
    public static void main(String[] args) {
        int[] houses={2,7,9,3,1};
        System.out.println(rob(houses));
    }

     public static int rob(int[] nums) {
        int[] dp =new int[nums.length];
        if(nums.length==1) return nums[0];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]); //初始化

        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]); //关键的一步
        }

        return dp[nums.length-1];
     }

}

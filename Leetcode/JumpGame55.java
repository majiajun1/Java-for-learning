public class JumpGame55 {
    public static void main(String[] args) {
        int[]  nums={2,3,1,1,4};
        System.out.println(canJump(nums));

    }
    public static boolean canJump(int[] nums) { //too slow
        if (nums==null || nums.length<=1)
            return true;
        if(nums[0]==0)
            return false;
        boolean[] dp=new boolean[nums.length];
        dp[0]=true;
        for (int i=0;i<nums.length;i++) {
            if(dp[i]){
            for(int j=0;j<=nums[i];j++) {
                dp[i+j]=true;
                if(i+j==nums.length-1)
                {
                    break;
                }
            }
            if(dp[nums.length-1])
            {
                return true;
            }
        }}
        return dp[nums.length-1];
    }

    public static boolean canJump2(int[] nums){
        int farthest=0;
        for (int i = 0; i < nums.length; i++) {
            if (i>farthest )
            {
                return false;
            }
            farthest = Math.max(farthest, i+nums[i]);
            if(farthest>=nums.length-1)
            {
                return true;
            }
        }
        return false;
    }

}

public class SmallestSubSeq209 {
    public static void main(String[] args) {
        int[] nums = {1,4,4};
        int target = 4;
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int ans=Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while(sum>= target){


                if(right-left+1<ans){
                    ans=right-left+1;
                }
                sum -= nums[left];
                left++;



            }

                right++;

        }
        if(ans==Integer.MAX_VALUE)
        {
            return 0;
        }

        return ans;
    }
}


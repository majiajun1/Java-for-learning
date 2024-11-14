public class DeleteLongestZi1493 {
    public static void main(String[] args) {
        int[]  input={1,1,1};
        int ans=longestSubarray(input);
        System.out.println(ans);
    }

    public static int longestSubarray(int[] nums) {

        int left=0;

        int zerocount=0;

        int ans=0;


        for(int i=0;i<nums.length;i++) {
            if (nums[i] == 0) {
                zerocount++;
            }
            while (zerocount > 1) {
                if (nums[left] == 0) {
                    zerocount--;
                }
                left++;
            }
            ans = Math.max(ans, i-left);


        }
        return ans;
    }

}

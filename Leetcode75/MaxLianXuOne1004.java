public class MaxLianXuOne1004 {
    public static void main(String[] args) {
        int[] input={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k=3;
        int ans=longestOnes(input,k);
        System.out.println(ans);

    }

    public static int longestOnes(int[] nums, int k) { //滑动窗口  右边是第k个0  左边是第一个1或第一个0
        int left=0;

        int zerocount=0;

        int max=0;


        for(int i=0;i<nums.length;i++) {
            if (nums[i] == 0) {
                zerocount++;
            }
            while (zerocount > k) {
                if (nums[left] == 0) {
                    zerocount--;
                }
                left++;
            }

            max=Math.max(max,i-left+1);
        }





        return max;
    }
}

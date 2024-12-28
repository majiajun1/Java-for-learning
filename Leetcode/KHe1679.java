import java.util.*;
public class KHe1679 {
    public static void main(String[] args) {

        int[] input={3,1,3,4,3};
        int k=6;
        int ans=maxOperations(input,k);
        System.out.println(ans);
    }

    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left=0,right=nums.length-1;
        int count=0;
        int m=0;
        while(left<right) {
            m = nums[left] + nums[right];
            if (m == k) {
                count += 1;
                left += 1;
                right -= 1;
            } else if (m < k)
                left += 1;
            else
                right -= 1;
        }
        return count;
    }
}

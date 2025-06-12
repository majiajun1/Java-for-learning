import java.util.*;
public class L16 {
    public static void main(String[] args) {
        int[] nums={4,0,5,-5,3,3,0,-4,-5};
        System.out.println(threeSumClosest(nums,-2));
    }
     public static int threeSumClosest(int[] nums, int target) {
        if(nums.length<3)
        {
            return 0;
        }
        int left=0,mid=1,right=2;
        int leftmax=-100000;
        int rightmin=10000000;
        Arrays.sort(nums);
        while(right<nums.length)
        {
            int cur=nums[left++]+nums[mid++]+nums[right++];
            if(cur==target)
            {
                return cur;
            }
            if(cur>leftmax&&cur<target)
            {
                leftmax=cur;
            }
            if(cur<rightmin&&cur>target)
            {
                rightmin=cur;
            }
        }
        if(Math.abs(target-leftmax)>Math.abs(target-rightmin))
        {
            return rightmin;
        }else
        {
            return leftmax;
        }
    }
}

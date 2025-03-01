import java.util.Arrays;
import java.util.List;

public class FirstAndLastPosition34 {
    public static void main(String[] args) {
        searchRange(new int[]{1,4},4);
    }
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        if (nums.length == 1) {
            if (target == nums[0])
                return new int[]{0, 0};
            else
                return new int[]{-1, -1};
        }


        int right = nums.length - 1;
        int left = 0;
        int[] res = new int[2];
        int   mid=0;
        Arrays.fill(res, -1);
        while(left<right){
          mid=left+(right-left)/2;
            if(nums[mid]==target){
                break;
            }else
                if(nums[mid]<target){
                    left=mid+1;

                }else
                    right=mid;
        }

        if(left==right){
            if(nums[left]==target){
                res[0]=left;
                res[1]=left;
                return res;
            }else
            {
                return res;
            }

        }

          left=0;
        res[0]=mid;
        res[1]=mid;
         for(int i=mid;i<nums.length;i++){
             if(nums[i]==target){
                 if(i==right)
                 {
                     res[1]=i;
                 }else {
                 continue;}
             }else
             {
                 res[1]=i-1;
                 break;
             }
         }
         for(int i=mid;i>=0;i--){
             if(nums[i]==target){
                 if(i==0)
                 {
                     res[0]=0;
                     break;
                 }else
                 {
                       continue;
                 }

             }else
             {
                 res[0]=i+1;
                 break;
             }
         }
         return res;




    }
}

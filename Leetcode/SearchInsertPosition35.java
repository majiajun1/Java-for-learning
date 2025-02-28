public class SearchInsertPosition35 {
    public int searchInsert(int[] nums, int target) {
        int right=nums.length-1;
        int left=0;

        while(left<right){
         int   mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else
                if(nums[mid]<target){
                    left=mid+1;

                }else
                    right=mid;
        }

        if(left==right)
        {
            if(nums[left]<target)
            {
                return left+1;
            }else
            {
                return left ;
            }
        }

        return -1;
    }
}

public class SearchRoundSorted33 {
    public int search(int[] nums, int target) {
       if (nums.length == 1)
       {
           if (nums[0] == target)
               return 0;
           else
               return -1;
       }


        int right=nums.length-1;

        int max=nums[0];
        int index=0;
        while(index<=right){

            if(nums[index]==target){
                return index;
            }

            if(nums[index]>=max){
                max=nums[index];
                index++;
            }else
            {
                break;
            }
        }
        int left=index;
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
            if (nums[left]==target)
                return left;
            else
                return -1;
        }




        return -1;
    }

}

import java.util.Arrays;

public class RemoveEle27 {
    public static void main(String[] args) {
        int[]  nums={0,1,2,2,3,0,4,2};
        int val=2;
        System.out.println(removeElement(nums,val));
    }



    public static int removeElement(int[] nums, int val) {
           Arrays.sort(nums);
        int count=0;
         int index=0;
         int index2=0;

         while(index2<nums.length) {
             if(nums[index2]!=val) {
                 nums[index++]=nums[index2++];
             }
             else {
                 index2++;
                 count++;
             }
         }




         return nums.length-count;

    }
}

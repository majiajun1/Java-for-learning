public class DeleteII80 {
    public static void main(String[] args) {
        int[] arr={0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(arr));

    }


       public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

         int index1 = 0;
         int index2 = 1;
         int count=1;  //重复次数
         while (index2 < nums.length) {
             if (nums[index1] == nums[index2]&&count<2) {
                 count++;
                 index1++;

                nums[index1] = nums[index2];
             }

             else if(nums[index1]!=nums[index2])
             {

                 count=1;

                 index1++;
                 nums[index1] = nums[index2];
             }
             index2++;
         }
         return index1+1;

    }
}

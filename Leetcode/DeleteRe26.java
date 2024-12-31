import java.util.*;

public class DeleteRe26 {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates2(arr));
    }


public static int removeDuplicates(int[] nums) {

         TreeSet<Integer> set = new TreeSet<>();

        for(int i:nums)
        {
            set.add(i);
        }
        int index = 0;
       for (int num : set) {
        nums[index++] = num; // 填充回数组
        }



        return set.size();
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; // 空数组
        }

        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[index])
            {
                nums[++index] = nums[i];

            }
        }
        return index+1;
    }
}

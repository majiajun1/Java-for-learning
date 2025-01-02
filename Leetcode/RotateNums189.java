import java.lang.reflect.ParameterizedType;

public class RotateNums189 {
    public static void main(String[] args) {
        int[] nums={1,2};
        int k=3;
        rotate(nums,k);
        for (int i:nums)
        {
            System.out.println(i);
        }
    }

    public static void rotate(int[] nums, int k) {
        if (nums.length == 0||nums.length==1)
            return;

        int realk=k%nums.length;


        int[] temp=new int[nums.length];
        for (int i=realk;i<nums.length;i++)
        {
            temp[i]=nums[i-realk];
        }
        for(int i =0;i<realk;i++)
        {
            temp[i]=nums[nums.length-realk+i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i]=temp[i];
        }
    }
}

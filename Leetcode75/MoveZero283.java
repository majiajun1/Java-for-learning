import java.util.ArrayList;

public class MoveZero283 {

    public static void main(String[] args) {


        int[]  nums={0,1,0,3,12};
        moveZeroes2(nums);
       for (int i:nums) {System.out.print(i+" ");}
    }




    public static void moveZeroes(int[] nums) {


        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                for (int j=i+1; j<nums.length; j++){
                    if(nums[j]!=0){
                        nums[i]=nums[j];
                        nums[j]=0;
                        break;
                    }
                }
            }
        }
    }

    public static void moveZeroes2(int[] nums) {
        if (nums == null)
            return;
        int j = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0)
                nums[j++] = nums[i];
        for (int i = j; i < nums.length; i++)
            nums[i] = 0;
    }


}

import java.util.Arrays;
import java.util.*;

public class OnlyOnce136 {

    public static void main(String[] args) {

        int[]  nums={2,2,1};
        System.out.println(singleNumber(nums));

    }

    public static int singleNumber(int[] nums) {
        if(nums==null || nums.length==0) return -1;
        if(nums.length==1) return nums[0];

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey(); // 找到后直接返回
            }
        }




        return -1;
    }


    public static int singleNumber2(int[] nums) { //异或
        if(nums==null || nums.length==0) return -1;
        if(nums.length==1) return nums[0];

        int result = 0;
    for (int num : nums) {
        result ^= num;
    }
    return result;




    }
}

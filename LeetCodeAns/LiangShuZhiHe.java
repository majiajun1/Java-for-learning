import java.util.*;
public class LiangShuZhiHe {
     public static void main(String[] args) {
         int ans[];
         int nums[]= {2,7,11,15};
         int target=9;
         ans=twoSum2(nums,target);
         System.out.println(ans[0]+" "+ans[1]);
     }
     public static  int[] twoSum(int[] nums, int target) {
         int[] index ={0,0};  //暴力解
         for(int i=0;i<nums.length;i++)
         {
             for(int j=i+1;j<nums.length;j++)
             {
                 if(nums[i]+nums[j]==target) {
                     index[0] = i;
                     index[1] = j;
                 }

             }
         }
            return index;
     }
     public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }


}

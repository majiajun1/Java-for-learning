import java.util.HashMap;
import java.util.HashSet;

public class ChongFuEleII219 {
    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        int k=3;
        System.out.println(containsNearbyDuplicate(nums,k));

    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
             if(!map.containsKey(nums[i]))
             {
                 map.put(nums[i],i);
             }else {
                 int val=map.get(nums[i]);
                 if(i-val<=k)
                 {
                     return true;
                 }else
                 {
                     map.remove(nums[i]);
                     map.put(nums[i],i);
                 }
             }
        }
        return false;
    }
}

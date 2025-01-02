import java.util.HashMap;
import java.util.Map;

public class DuoShu169 {
    public static void main(String[] args) {
        int[] nums={3,2,3};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i:nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int n=nums.length/2;
        for (Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            if (entry.getValue()>n)
            {
                return entry.getKey();
            }
        }
        return -1;
    }
}

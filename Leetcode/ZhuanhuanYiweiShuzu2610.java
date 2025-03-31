import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZhuanhuanYiweiShuzu2610 {
    public static void main(String[] args) {
        int[] nums={1,3,4,1,2,3,1};
        findMatrix(nums);
    }
    public static List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int value=entry.getValue();
            while (res.size()<value){
                res.add(new ArrayList<>());
            }
            for(int i=0;i<value;i++)
            {
                res.get(i).add(entry.getKey());
            }

        }




        return res;
    }
}

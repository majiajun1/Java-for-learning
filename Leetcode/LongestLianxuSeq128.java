import java.util.*;

public class LongestLianxuSeq128 {
    public static void main(String[] args) {
        int[] nums={1,2,0,1};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        HashSet<Integer> set=new HashSet<>();
        int count = 1;
        int max=0;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                list.add(nums[i]);
            }

        }
        Collections.sort(list);
        for(int i=1;i<list.size();i++){
            if(list.get(i)==list.get(i-1)+1){
                count++;
            }else
            {
                if(count>max){
                    max=count;

                }
                count=1;
            }

        }

        if(count>max){
                    max=count;

                }
        return max;
    }
}

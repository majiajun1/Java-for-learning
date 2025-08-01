/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TotalCombine39 {
    int target;
    ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         this.target = target;
         Arrays.sort(candidates);
        ArrayList<Integer> temp=new ArrayList<>();
        for (int i = 0; i <candidates.length; i++) {
            temp.add(candidates[i]);

            dfs(temp,candidates,candidates[i],i);
            temp.remove(temp.size()-1);

        }
        return res;

    }

    public void dfs(ArrayList<Integer> list,int[] nums,int cur,int start)
    {
        if(cur==target)
        {
            res.add(new ArrayList<>(list));
            return;
        }else
        {
            if(cur>target)
                return;
        }

        for (int i = start; i < nums.length; i++) {

            list.add(nums[i]);

            dfs(list,nums,cur+nums[i],i);
            list.remove(list.size()-1);

        }
    }
}

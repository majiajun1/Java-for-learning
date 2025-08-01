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

public class Full46 {
    int len;
    ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        len = nums.length;
        boolean[] visited = new boolean[len];
        ArrayList<Integer> temp=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            temp.add(nums[i]);
            visited[i] = true;
            dfs(temp,visited,nums);
            temp.remove(temp.size()-1);
            visited[i] = false;
        }
        return res;

    }

    public void dfs(ArrayList<Integer> list,boolean[] visited,int[] nums)
    {
        if(list.size()==len)
        {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(visited[i])
            {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            dfs(list,visited,nums);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }

}

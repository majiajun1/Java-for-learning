/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleToIntFunction;

public class Combine77 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    int n;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        List<Integer> temp=new ArrayList<>();
        for(int i = 1; i <= n; ++i)
        {

            temp.add(i);
            dfs(temp,k);
            temp.remove(temp.size()-1);

        }
        return res;
    }

    public void dfs(List<Integer> list,int k)
    {
        if(list.size()==k)
        {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i =list.get(list.size()-1)+1; i<=n; ++i)
        {

           list.add(i);
            dfs(list,k);
            list.remove(list.size()-1);
        }
    }
}

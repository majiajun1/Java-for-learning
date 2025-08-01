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

public class Kuohao22 {
    int max;
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        this.max = n;
        dfs(new StringBuilder(),0,0);

        return result;
    }


    public void dfs(StringBuilder sb,int leftKuohao,int rightKuohao)
    {
        if(sb.length()==max*2&&leftKuohao==rightKuohao&&leftKuohao==max)
        {
            result.add(new String(sb));
            return;
        }

        if(leftKuohao<max)
        {
            sb.append("(");
            dfs(sb,leftKuohao+1,rightKuohao);
            sb.deleteCharAt(sb.length()-1);
        }

        if(rightKuohao<leftKuohao)
        {
            sb.append(")");
            dfs(sb,leftKuohao,rightKuohao+1);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}

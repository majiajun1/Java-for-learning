/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayList;

public class Ksmall230 {
    int index = 0;
    int curk;
    int ans=0;
    public int kthSmallest(TreeNode root, int k) {
        curk=k;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;


        dfs(root.left);
        index++;
        if(index == curk){
            ans= root.val;
            return;}
        dfs(root.right);
    }
}

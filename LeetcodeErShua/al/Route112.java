/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

public class Route112 {
    static int targetSum ;
    public boolean hasPathSum(TreeNode root, int targetsum) {
        targetSum = targetsum;
        if (root == null) return false;
        return diGui(root, 0);
    }

    public boolean diGui(TreeNode root, int curSum) {

        if (root == null) return false;
        int cur=curSum + root.val;

        if(cur == targetSum&&root.left == null && root.right == null) {
            return true;
        }else
        {

           return    diGui(root.left, cur) ||  diGui(root.right, cur);
        }

    }
}

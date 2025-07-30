/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayDeque;

public class Valid98 {

     long lastOne=Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if(root.left==null && root.right==null)
        {
            return true;
        }

        return   isValidBST2(root);
    }


    public  boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        long cur = root.val;
        boolean thisOne= true;
        thisOne= thisOne && isValidBST2(root.left);




        if(  lastOne >= cur) return false;
        else
        {
            lastOne=cur;

        }

        thisOne = thisOne &&  isValidBST2(root.right);

        return thisOne;

    }
}

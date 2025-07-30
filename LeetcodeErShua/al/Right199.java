/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Right199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        ArrayDeque<TreeNode> q = new ArrayDeque<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size-1; i++) {
                TreeNode node = q.poll();
                if(node.left != null) q.addLast(node.left);
                if(node.right != null) q.addLast(node.right);
            }
            TreeNode last=q.poll();
            res.add(last.val);
            if(last.left != null) q.addLast(last.left);
            if(last.right != null) q.addLast(last.right);
        }
        return res;
    }
}
